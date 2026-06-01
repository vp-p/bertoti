package controller;

import model.Estoque;
import model.Produto;

public class EstoqueController {
    private Estoque estoque;
    private EstrategiaDesconto estrategia;

    public EstoqueController(Estoque estoque) {
        this.estoque = estoque;
    }

    public void setEstrategiaDesconto(EstrategiaDesconto estrategia) {
        this.estrategia = estrategia;
    }

    public void adicionarProduto(Produto p) {
        estoque.adicionarProduto(p);
    }

    public void aplicarDesconto() {
        if (estrategia == null) return;
        estrategia.aplicar(estoque.getProdutos());
        estoque.notificarObservadores();
    }
}
