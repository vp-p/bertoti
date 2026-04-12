# Anti-padrão: Acoplamento direto entre publicador e observadores

O publicador conhece e instancia diretamente cada classe concreta de observador. Qualquer novo observador exige modificar o `SensorTemperatura`, violando o princípio Aberto/Fechado.

## Estrutura

```
+------------------------------------------+
|           SensorTemperatura              |
+------------------------------------------+
| - alertaClimatico: AlertaClimatico       |  ← dependência concreta
| - registroTemperatura: RegistroTemperatura|  ← dependência concreta
+------------------------------------------+
| + setTemperatura(double): void           |
+------------------------------------------+
          |                   |
          | chama diretamente | chama diretamente
          v                   v
+------------------+   +--------------------+
| AlertaClimatico  |   | RegistroTemperatura|
+------------------+   +--------------------+
| + notificar()    |   | + notificar()      |
+------------------+   +--------------------+
```

## Problema: modificação obrigatória do publicador

Para adicionar um novo observador (ex: `PainelMeteorologico`), é necessário alterar `SensorTemperatura`:

```java
// Toda nova "escuta" exige mexer aqui:
public class SensorTemperatura {
    private AlertaClimatico alertaClimatico = new AlertaClimatico();
    private RegistroTemperatura registroTemperatura = new RegistroTemperatura();
    private PainelMeteorologico painel = new PainelMeteorologico(); // ← nova linha
    
    public void setTemperatura(double temperatura) {
        alertaClimatico.notificar(temperatura);
        registroTemperatura.notificar(temperatura);
        painel.notificar(temperatura); // ← nova linha
    }
}
```

## Participantes

| Classe | Papel | Problema |
|---|---|---|
| `SensorTemperatura` | Publicador | Acoplado às classes concretas — viola Aberto/Fechado |
| `AlertaClimatico` | Observador | Sem interface comum, não é intercambiável |
| `RegistroTemperatura` | Observador | Sem interface comum, não é intercambiável |
| `Main` | Cliente | Não pode registrar ou remover observadores em tempo de execução |

## Exemplo de uso [Main.java]

```java
SensorTemperatura sensor = new SensorTemperatura();

// Não há como adicionar ou remover observadores aqui.
// Os observadores estão fixos dentro do próprio SensorTemperatura.
sensor.setTemperatura(22.0);
sensor.setTemperatura(38.0);
sensor.setTemperatura(-3.0);
```
