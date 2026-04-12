# Anti-padrão: Herança para variar comportamento

Uso de herança para representar variações de comportamento de formatação. Cada novo formato exige uma nova subclasse de `TextEditor`, acoplando comportamento e estrutura de forma não escalável.

## Estrutura

```
+------------------------------+
|         TextEditor           |
+------------------------------+
| + publishText(String): String|
+------------------------------+
              △
              | herda
    __________|___________
   |          |           |
+----------+ +----------+ +------------------+
| UpperCase| | LowerCase| | CamelCase        |
| TextEditor| | TextEditor| | TextEditor      |
+----------+ +----------+ +------------------+
|publishText| |publishText| | publishText     |
+----------+ +----------+ +------------------+

+--------+
|  Main  |  instancia diretamente cada subclasse
+--------+
```

## Problema: explosão de classes

Se uma nova dimensão for adicionada — por exemplo, o destino da saída do texto (salvar em arquivo `.txt` ou imprimir no console) — o número de subclasses cresce exponencialmente, pois cada combinação de formato + destino exigiria sua própria classe:

```
                        TextEditor
                            △
              ______________|______________
             |               |             |
        UpperCase         LowerCase     CamelCase       ← 3 classes (formato)
            *                 *             *
           / \               / \           / \
  SalvaArquivo Imprime  SalvaArquivo Imprime  SalvaArquivo Imprime      ← 6 classes (formato + destino)
                                                         
```

Ou seja, seriam necessárias classes como `UpperCaseSalvaArquivoTextEditor`, `UpperCaseImprimeTextEditor`, `LowerCaseSalvaArquivoTextEditor`, etc.

Adicionar um novo formato ou um novo destino exige criar e manter N × M subclasses.

## Participantes

| Classe | Papel | Problema |
|---|---|---|
| `TextEditor` | Classe base | Obriga subclasses para qualquer variação |
| `UpperCaseTextEditor` | Subclasse | Existe apenas para trocar um comportamento |
| `LowerCaseTextEditor` | Subclasse | Existe apenas para trocar um comportamento |
| `CamelCaseTextEditor` | Subclasse | Existe apenas para trocar um comportamento |
| `Main` | Cliente | Instancia um objeto novo para cada formato |

## Exemplo de uso [Main.java]

```java
// Impossível trocar o formato em tempo de execução no mesmo objeto.
// Cada variação exige instanciar uma subclasse diferente.
TextEditor upper = new UpperCaseTextEditor();
upper.publishText("hello, world!"); // HELLO, WORLD!

TextEditor lower = new LowerCaseTextEditor();
lower.publishText("hello, world!"); // hello, world!

TextEditor camel = new CamelCaseTextEditor();
camel.publishText("hello, world!"); // Hello, World!
```
