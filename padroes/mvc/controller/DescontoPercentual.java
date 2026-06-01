package controller;

import model.Produto;

import java.util.List;

public class DescontoPercentual implements EstrategiaDesconto {
    private double percentual;

    public DescontoPercentual(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public void aplicar(List<Produto> produtos) {
        for (Produto p : produtos) {
            p.setPreco(p.getPreco() * (1 - percentual / 100));
        }
        System.out.printf("[Strategy] Desconto percentual de %.0f%% aplicado.%n", percentual);
    }
}
