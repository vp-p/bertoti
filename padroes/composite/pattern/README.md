# Padrão de projeto: Composite

Padrão estrutural que compõe objetos em estruturas de árvore e permite tratá-los de forma uniforme, independentemente de serem simples (folhas) ou compostos (nós).

## Estrutura

```
+-------------------------+
|      <<interface>>      |
|       Componente        |
+-------------------------+
| + getNome(): String     |
| + getTamanho(): int     |
+-------------------------+
            △
            |  implementa
     _______|_______
    |               |
+----------+   +---------------------------------+
|  Arquivo |   |             Pasta               |
+----------+   +---------------------------------+
| - nome   |   | - nome                          |
| - tamanho|   | - filhos: List<Componente>      |
+----------+   +---------------------------------+
| getNome()|   | + adicionar(Componente): void   |
| getTamanho() | + getNome(): String             |
+----------+   | + getTamanho(): int (recursivo) |
               +---------------------------------+

+--------+
|  Main  |  trabalha apenas com Componente
+--------+
```

## Como a recursão funciona

```
projeto/ (getTamanho)
├── README.md → 5 KB
└── src/ (getTamanho)
    ├── Main.java → 12 KB
    └── Util.java → 8 KB
         └── total src  = 20 KB
    └── total projeto = 25 KB
```

`Pasta.getTamanho()` percorre os filhos e chama `getTamanho()` em cada um — se o filho for outra `Pasta`, a recursão continua automaticamente.

## Participantes

| Classe | Papel | Descrição |
|---|---|---|
| `Componente` | Interface | Contrato comum a folhas e compostos |
| `Arquivo` | Folha | Elemento terminal — retorna seu próprio tamanho |
| `Pasta` | Composto | Contém outros `Componente`, delega recursivamente |
| `Main` | Cliente | Trata arquivos e pastas de forma idêntica |

## Exemplo de uso [Main.java]

```java
Pasta src = new Pasta("src");
src.adicionar(new Arquivo("Main.java", 12));
src.adicionar(new Arquivo("Util.java", 8));

Pasta projeto = new Pasta("projeto");
projeto.adicionar(new Arquivo("README.md", 5));
projeto.adicionar(src); // pasta dentro de pasta

System.out.println(projeto.getTamanho()); // 25 KB
```
