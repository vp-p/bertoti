package view;

import model.Produto;

public class ItemProdutoView implements ComponenteView {
    private Produto produto;

    public ItemProdutoView(Produto produto) {
        this.produto = produto;
    }

    @Override
    public void renderizar() {
        System.out.printf("  - %-20s R$ %.2f%n", produto.getNome(), produto.getPreco());
    }
}
