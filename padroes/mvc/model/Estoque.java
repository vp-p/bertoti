package model;

import java.util.ArrayList;
import java.util.List;

public class Estoque implements Observavel {
    private List<Produto> produtos = new ArrayList<>();
    private List<Observador> observadores = new ArrayList<>();

    public void adicionarProduto(Produto p) {
        produtos.add(p);
        notificarObservadores();
    }

    public void removerProduto(Produto p) {
        produtos.remove(p);
        notificarObservadores();
    }

    public List<Produto> getProdutos() {
        return new ArrayList<>(produtos);
    }

    @Override
    public void adicionarObservador(Observador o) {
        observadores.add(o);
    }

    @Override
    public void removerObservador(Observador o) {
        observadores.remove(o);
    }

    @Override
    public void notificarObservadores() {
        for (Observador o : observadores) {
            o.atualizar(getProdutos());
        }
    }
}
