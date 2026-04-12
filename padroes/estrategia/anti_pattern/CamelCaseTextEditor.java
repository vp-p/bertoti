// Subclasse obrigada a existir apenas para mudar o comportamento de formatação
public class CamelCaseTextEditor extends TextEditor {

    @Override
    public String publishText(String text) {
        String[] words = text.toLowerCase().split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0)))
                      .append(word.substring(1))
                      .append(" ");
            }
        }

        return result.toString().trim();
    }
}
