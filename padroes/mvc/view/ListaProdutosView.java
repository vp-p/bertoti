package view;

import model.Observador;
import model.Produto;

import java.util.List;

// Implementa Observador (Observer) e ComponenteView (Composite)
// É notificada automaticamente pelo Model e reconstrói sua árvore de componentes
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
    }

    @Override
    public void renderizar() {
        painel.renderizar();
    }
}
