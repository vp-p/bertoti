package view;

import model.Produto;

import javax.swing.*;
import java.awt.*;

public class ItemProdutoView implements ComponenteView {
    private Produto produto;

    public ItemProdutoView(Produto produto) {
        this.produto = produto;
    }

    @Override
    public JComponent getComponente() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(6, 10, 6, 10));
        JLabel nome = new JLabel(produto.getNome());
        JLabel preco = new JLabel(String.format("R$ %.2f", produto.getPreco()));
        preco.setHorizontalAlignment(SwingConstants.RIGHT);
        panel.add(nome, BorderLayout.WEST);
        panel.add(preco, BorderLayout.EAST);
        return panel;
    }
}
