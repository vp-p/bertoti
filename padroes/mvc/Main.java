import controller.DescontoFixo;
import controller.DescontoPercentual;
import controller.EstoqueController;
import model.Estoque;
import model.Produto;
import view.ListaProdutosView;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();

        ListaProdutosView view = new ListaProdutosView("Catálogo de Produtos");
        estoque.adicionarObservador(view);

        EstoqueController controller = new EstoqueController(estoque);

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Gerenciador de Estoque");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());

            frame.add(view.getComponente(), BorderLayout.CENTER);

            JPanel controles = new JPanel();

            JButton btnAdicionar = new JButton("+ Produto");
            btnAdicionar.addActionListener(e -> {
                String nome = JOptionPane.showInputDialog(frame, "Nome do produto:");
                if (nome == null || nome.isBlank()) return;
                String precoStr = JOptionPane.showInputDialog(frame, "Preço:");
                if (precoStr == null) return;
                try {
                    double preco = Double.parseDouble(precoStr.replace(",", "."));
                    controller.adicionarProduto(new Produto(nome, preco));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Preço inválido.");
                }
            });

            JButton btnDescontoPerc = new JButton("Desconto %");
            btnDescontoPerc.addActionListener(e -> {
                String val = JOptionPane.showInputDialog(frame, "Percentual de desconto:");
                if (val == null) return;
                try {
                    double pct = Double.parseDouble(val.replace(",", "."));
                    controller.setEstrategiaDesconto(new DescontoPercentual(pct));
                    controller.aplicarDesconto();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Valor inválido.");
                }
            });

            JButton btnDescontoFixo = new JButton("Desconto Fixo");
            btnDescontoFixo.addActionListener(e -> {
                String val = JOptionPane.showInputDialog(frame, "Valor do desconto (R$):");
                if (val == null) return;
                try {
                    double valor = Double.parseDouble(val.replace(",", "."));
                    controller.setEstrategiaDesconto(new DescontoFixo(valor));
                    controller.aplicarDesconto();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Valor inválido.");
                }
            });

            controles.add(btnAdicionar);
            controles.add(btnDescontoPerc);
            controles.add(btnDescontoFixo);

            frame.add(controles, BorderLayout.SOUTH);

            frame.setSize(400, 400);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            controller.adicionarProduto(new Produto("Notebook", 2500.00));
            controller.adicionarProduto(new Produto("Mouse", 150.00));
            controller.adicionarProduto(new Produto("Teclado", 200.00));
        });
    }
}
