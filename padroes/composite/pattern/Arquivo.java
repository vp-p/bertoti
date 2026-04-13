package pattern;

// Folha: elemento terminal da árvore, não contém filhos
public class Arquivo implements Componente {

    private String nome;
    private int tamanho;

    public Arquivo(String nome, int tamanho) {
        this.nome = nome;
        this.tamanho = tamanho;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public int getTamanho() {
        return tamanho;
    }
}
