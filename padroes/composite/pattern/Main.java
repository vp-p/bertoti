package pattern;

// Cliente: trata arquivos e pastas de forma uniforme através da interface Componente
public class Main {
    public static void main(String[] args) {
        Arquivo readme   = new Arquivo("README.md", 5);
        Arquivo main     = new Arquivo("Main.java", 12);
        Arquivo util     = new Arquivo("Util.java", 8);

        Pasta src = new Pasta("src");
        src.adicionar(main);
        src.adicionar(util);

        Pasta projeto = new Pasta("projeto");
        projeto.adicionar(readme);
        projeto.adicionar(src);  // pasta dentro de pasta

        // A mesma chamada funciona para arquivo, subpasta ou pasta raiz
        System.out.println(readme.getNome()  + ": " + readme.getTamanho()  + " KB"); // 5 KB
        System.out.println(src.getNome()     + ": " + src.getTamanho()     + " KB"); // 20 KB
        System.out.println(projeto.getNome() + ": " + projeto.getTamanho() + " KB"); // 25 KB
    }
}
