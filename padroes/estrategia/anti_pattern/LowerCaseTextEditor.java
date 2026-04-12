// Subclasse obrigada a existir apenas para mudar o comportamento de formatação
public class LowerCaseTextEditor extends TextEditor {

    @Override
    public String publishText(String text) {
        return text.toLowerCase();
    }
}
