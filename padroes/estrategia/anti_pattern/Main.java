/* Problema: trocar o comportamento exige instanciar um objeto completamente novo.
Não é possível mudar a formatação em tempo de execução sem trocar a referência.
Adicionar um novo formato = criar mais uma subclasse de TextEditor.*/
public class Main {
    public static void main(String[] args) {
        String text = "Giuliano Bertoti - PADROES: estrategia";

        TextEditor upper = new UpperCaseTextEditor();
        System.out.println(upper.publishText(text));

        TextEditor lower = new LowerCaseTextEditor();
        System.out.println(lower.publishText(text));

        TextEditor camel = new CamelCaseTextEditor();
        System.out.println(camel.publishText(text));
    }
}
