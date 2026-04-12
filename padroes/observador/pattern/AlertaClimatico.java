package pattern;

// Observador concreto: emite alerta quando a temperatura ultrapassa limites
public class AlertaClimatico implements Observador {

    @Override
    public void atualizar(double temperatura) {
        if (temperatura > 35) {
            System.out.println("ALERTA: temperatura muito alta! " + temperatura + "°C");
        } else if (temperatura < 0) {
            System.out.println("ALERTA: temperatura abaixo de zero! " + temperatura + "°C");
        }
    }
}
