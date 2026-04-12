package anti_pattern;

// Sem interface: acoplado diretamente ao SensorTemperatura
public class AlertaClimatico {

    public void notificar(double temperatura) {
        if (temperatura > 35) {
            System.out.println("ALERTA: temperatura muito alta! " + temperatura + "°C");
        } else if (temperatura < 0) {
            System.out.println("ALERTA: temperatura abaixo de zero! " + temperatura + "°C");
        }
    }
}
