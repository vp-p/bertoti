package anti_pattern;

// Sem interface: acoplado diretamente ao SensorTemperatura
public class RegistroTemperatura {

    public void notificar(double temperatura) {
        System.out.println("Registro: temperatura atualizada para " + temperatura + "°C");
    }
}
