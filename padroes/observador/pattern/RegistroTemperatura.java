package pattern;

// Observador concreto: registra cada leitura de temperatura
public class RegistroTemperatura implements Observador {

    @Override
    public void atualizar(double temperatura) {
        System.out.println("Registro: temperatura atualizada para " + temperatura + "°C");
    }
}
