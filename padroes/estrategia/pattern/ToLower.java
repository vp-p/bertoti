//Estratégia concreta para converter texto para minúsculas
public class ToLower implements Formatter {
    @Override
    public String format(String text) {
        return text.toLowerCase();
    }
    
}
