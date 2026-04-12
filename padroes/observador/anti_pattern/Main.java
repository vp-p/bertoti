package anti_pattern;

// Impossível registrar novos observadores sem modificar SensorTemperatura
public class Main {
    public static void main(String[] args) {
        SensorTemperatura sensor = new SensorTemperatura();

        sensor.setTemperatura(22.0);
        sensor.setTemperatura(38.0);
        sensor.setTemperatura(-3.0);
    }
}
