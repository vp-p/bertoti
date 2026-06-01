package view;

import java.util.List;
import javax.swing.JComponent;
import model.Observador;
import model.Produto;

public class ListaProdutosView implements ComponenteView, Observador {
    private PainelView painel;

    public ListaProdutosView(String titulo) {
        this.painel = new PainelView(titulo);
    }

    @Override
    public void atualizar(List<Produto> produtos) {
        painel.limpar();
        for (Produto p : produtos) {
            painel.adicionar(new ItemProdutoView(p));
        }
        painel.getComponente().revalidate();
        painel.getComponente().repaint();
    }

    @Override
    public JComponent getComponente() {
        return painel.getComponente();
    }
}
