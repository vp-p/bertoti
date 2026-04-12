package pattern;

import java.util.ArrayList;
import java.util.List;

// Publicador: mantém a lista de observadores e os notifica quando a temperatura muda
public class SensorTemperatura {

    private List<Observador> observadores = new ArrayList<>();
    private double temperatura;

    public void adicionarObservador(Observador o) {
        observadores.add(o);
    }

    public void removerObservador(Observador o) {
        observadores.remove(o);
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
        notificar();
    }

    private void notificar() {
        for (Observador o : observadores) {
            o.atualizar(temperatura);
        }
    }
}
