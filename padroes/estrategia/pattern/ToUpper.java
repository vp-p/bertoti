//Estratégia concreta para converter texto para maiúsculas
public class ToUpper implements Formatter {
    @Override
    public String format(String text) {
        return text.toUpperCase();
    }
}