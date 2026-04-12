// Cliente: cria as estratégias e as configura no contexto
public class Main {
    public static void main(String[] args) {
        String text = "Giuliano Bertoti - PADROES: estrategia";

        TextEditor editor = new TextEditor(new ToUpper());
        System.out.println(editor.publishText(text));

        editor.setFormatter(new ToLower());
        System.out.println(editor.publishText(text));

        editor.setFormatter(new CamelCaseFormatter());
        System.out.println(editor.publishText(text));
    }
}
