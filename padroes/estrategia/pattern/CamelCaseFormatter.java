//Estratégia concreta para converter texto para CamelCase
public class CamelCaseFormatter implements Formatter {

    @Override
    public String format(String text) {
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