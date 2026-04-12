# Padrão de projeto: Estratégia

Padrão comportamental que define uma família de algoritmos, encapsula cada um deles em classes separadas e os torna intercambiáveis em tempo de execução.

## Estrutura

```
+---------------------------+
|         <<interface>>     |
|          Formatter        |
+---------------------------+
| + format(String): String  |
+---------------------------+
            △
            |  implementa
     _______|________
    |        |       |
+-------+ +-------+ +-------------------+
|ToUpper| |ToLower| | CamelCaseFormatter|
+-------+ +-------+ +-------------------+
|format | |format | | format            |
+-------+ +-------+ +-------------------+

+------------------------------+        usa       +--------+
|         TextEditor           |<------------------+|  Main  |
+------------------------------+                    +--------+
| - formatter: Formatter       |
+------------------------------+
| + setFormatter(Formatter)    |
| + publishText(String): String|
+------------------------------+
            | delega para
            v
        Formatter
```


| Classe | Papel | Descrição |
|---|---|---|
| `Formatter` | Estratégia | Interface comum a todas as estratégias |
| `ToUpper` | Estratégia Concreta | Converte texto para maiúsculas |
| `ToLower` | Estratégia Concreta | Converte texto para minúsculas |
| `CamelCaseFormatter` | Estratégia Concreta | Converte texto para Title Case |
| `TextEditor` | Contexto | Mantém a referência à estratégia e delega a formatação |
| `Main` | Cliente | Cria as estratégias e as configura no contexto |

## Exemplo de uso [Main.java]

```java
TextEditor editor = new TextEditor(new ToUpper());
editor.publishText("hello, world!"); // HELLO WORLD

editor.setFormatter(new ToLower());
editor.publishText("hello, world!"); // hello world

editor.setFormatter(new CamelCaseFormatter());
editor.publishText("hello, world!"); // Hello World
```
