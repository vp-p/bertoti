package pattern;

import java.util.ArrayList;
import java.util.List;

// Composto: pode conter arquivos ou outras pastas, delega getTamanho() recursivamente
public class Pasta implements Componente {

    private String nome;
    private List<Componente> filhos = new ArrayList<>();

    public Pasta(String nome) {
        this.nome = nome;
    }

    public void adicionar(Componente c) {
        filhos.add(c);
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public int getTamanho() {
        int total = 0;
        for (Componente c : filhos) {
            total += c.getTamanho();
        }
        return total;
    }
}
