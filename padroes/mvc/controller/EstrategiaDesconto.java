package controller;

import model.Produto;

import java.util.List;

public interface EstrategiaDesconto {
    void aplicar(List<Produto> produtos);
}
