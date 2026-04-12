package pattern;

// Cliente: cria o sensor, registra os observadores e dispara as mudanças de estado
public class Main {
    public static void main(String[] args) {
        SensorTemperatura sensor = new SensorTemperatura();

        sensor.adicionarObservador(new RegistroTemperatura());
        sensor.adicionarObservador(new AlertaClimatico());

        sensor.setTemperatura(22.0);
        sensor.setTemperatura(38.0);
        sensor.setTemperatura(-3.0);
    }
}
