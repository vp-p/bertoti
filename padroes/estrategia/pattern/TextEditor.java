// Contexto: mantém a referência a estratégia e delega a formatação para ela
public class TextEditor {

    private Formatter formatter;

    public TextEditor(Formatter formatter) {
        this.formatter = formatter;
    }

    public void setFormatter(Formatter formatter) {
        this.formatter = formatter;
    }

    public String publishText(String text) {
        return formatter.format(text);
    }
}
