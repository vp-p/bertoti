// Subclasse obrigada a existir apenas para mudar o comportamento de formatação
public class UpperCaseTextEditor extends TextEditor {

    @Override
    public String publishText(String text) {
        return text.toUpperCase();
    }
}
