package anti_pattern;

import java.util.ArrayList;
import java.util.List;

// Anti-padrão: aceita apenas Arquivo — impossível aninhar pastas dentro de pastas
public class Pasta {

    private String nome;
    private List<Arquivo> arquivos = new ArrayList<>();

    public Pasta(String nome) {
        this.nome = nome;
    }

    public void adicionar(Arquivo a) {
        arquivos.add(a);
    }

    public String getNome() { return nome; }

    public int getTamanho() {
        int total = 0;
        for (Arquivo a : arquivos) {
            total += a.getTamanho();
        }
        return total;
    }
}
