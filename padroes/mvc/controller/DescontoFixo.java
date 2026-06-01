package controller;

import model.Produto;

import java.util.List;

public class DescontoFixo implements EstrategiaDesconto {
    private double valor;

    public DescontoFixo(double valor) {
        this.valor = valor;
    }

    @Override
    public void aplicar(List<Produto> produtos) {
        for (Produto p : produtos) {
            p.setPreco(Math.max(0, p.getPreco() - valor));
        }
        System.out.printf("[Strategy] Desconto fixo de R$ %.2f aplicado.%n", valor);
    }
}
