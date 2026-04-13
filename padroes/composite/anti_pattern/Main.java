package anti_pattern;

// Problema: não é possível aninhar pastas — a estrutura de árvore é inviável.
// Para calcular o tamanho total, o cliente precisa iterar manualmente cada pasta.
public class Main {
    public static void main(String[] args) {
        Arquivo readme = new Arquivo("README.md", 5);
        Arquivo main   = new Arquivo("Main.java", 12);
        Arquivo util   = new Arquivo("Util.java", 8);

        Pasta src = new Pasta("src");
        src.adicionar(main);
        src.adicionar(util);

        Pasta projeto = new Pasta("projeto");
        projeto.adicionar(readme);
        // projeto.adicionar(src); // ERRO: Pasta não aceita Pasta, só Arquivo

        // Para obter o total, o cliente é obrigado a somar manualmente
        int total = projeto.getTamanho() + src.getTamanho();
        System.out.println("projeto: " + total + " KB"); // 25 KB
    }
}
