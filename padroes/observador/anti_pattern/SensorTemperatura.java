package anti_pattern;

// Anti-padrão: acoplado diretamente às classes concretas dos observadores.
// Adicionar um novo observador exige modificar esta classe.
public class SensorTemperatura {

    private AlertaClimatico alertaClimatico = new AlertaClimatico();
    private RegistroTemperatura registroTemperatura = new RegistroTemperatura();

    public void setTemperatura(double temperatura) {
        alertaClimatico.notificar(temperatura);
        registroTemperatura.notificar(temperatura);
    }
}
