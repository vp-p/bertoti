# Padrão de projeto: Observador

Padrão comportamental que define uma relação de dependência um-para-muitos entre objetos, de forma que quando um objeto muda de estado, todos os seus dependentes são notificados automaticamente.

## Estrutura

```
+-----------------------------+
|         <<interface>>       |
|          Observador         |
+-----------------------------+
| + atualizar(double): void   |
+-----------------------------+
            △
            |  implementa
     _______|________
    |                |
+------------------+ +--------------------+
| AlertaClimatico  | | RegistroTemperatura|
+------------------+ +--------------------+
| + atualizar()    | | + atualizar()      |
+------------------+ +--------------------+

+------------------------------------------+       usa       +--------+
|           SensorTemperatura              |<----------------+|  Main  |
+------------------------------------------+                  +--------+
| - observadores: List<Observador>         |
| - temperatura: double                    |
+------------------------------------------+
| + adicionarObservador(Observador): void  |
| + removerObservador(Observador): void    |
| + setTemperatura(double): void           |
| - notificar(): void                      |
+------------------------------------------+
            | notifica todos
            v
        Observador
```

## Participantes

| Classe | Papel | Descrição |
|---|---|---|
| `Observador` | Interface | Contrato comum a todos os observadores |
| `AlertaClimatico` | Observador Concreto | Emite alerta se a temperatura for extrema |
| `RegistroTemperatura` | Observador Concreto | Registra cada leitura de temperatura |
| `SensorTemperatura` | Publicador | Mantém a lista de observadores e notifica ao mudar |
| `Main` | Cliente | Cria o sensor, registra os observadores e dispara eventos |

## Exemplo de uso [Main.java]

```java
SensorTemperatura sensor = new SensorTemperatura();

sensor.adicionarObservador(new RegistroTemperatura());
sensor.adicionarObservador(new AlertaClimatico());

sensor.setTemperatura(22.0);
// Registro: temperatura atualizada para 22.0°C

sensor.setTemperatura(38.0);
// Registro: temperatura atualizada para 38.0°C
// ALERTA: temperatura muito alta! 38.0°C

sensor.setTemperatura(-3.0);
// Registro: temperatura atualizada para -3.0°C
// ALERTA: temperatura abaixo de zero! -3.0°C
```
