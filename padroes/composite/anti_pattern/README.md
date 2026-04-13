# Anti-padrão: Container tipado para um único tipo de filho

`Pasta` aceita apenas `Arquivo` em sua lista interna. Sem uma interface comum, é impossível aninhar pastas dentro de pastas — a estrutura de árvore fica inviável.

## Estrutura

```
+----------+       +---------------------------+
|  Arquivo |       |           Pasta           |
+----------+       +---------------------------+
| - nome   |       | - arquivos: List<Arquivo> | ← só aceita Arquivo
| - tamanho|       +---------------------------+
+----------+       | + adicionar(Arquivo)      |
                   | + getTamanho(): int        |
                   +---------------------------+

  Sem interface comum — Arquivo e Pasta são tipos incompatíveis para o cliente.
```

## Problema: árvore impossível

```
projeto/
├── README.md  ← OK
└── src/       ← ERRO: Pasta.adicionar() não aceita outra Pasta
    ├── Main.java
    └── Util.java
```

Para calcular o tamanho total, o cliente é forçado a somar manualmente cada pasta:

```java
// Não há como delegar — o cliente conhece e opera cada pasta individualmente
int total = projeto.getTamanho() + src.getTamanho();
```

## Participantes

| Classe | Papel | Problema |
|---|---|---|
| `Arquivo` | Folha | Sem interface, incompatível com `Pasta` para o cliente |
| `Pasta` | Container | `List<Arquivo>` impede aninhamento de pastas |
| `Main` | Cliente | Obrigado a conhecer e somar cada pasta manualmente |

## Exemplo de uso [Main.java]

```java
Pasta src = new Pasta("src");
src.adicionar(new Arquivo("Main.java", 12));
src.adicionar(new Arquivo("Util.java", 8));

Pasta projeto = new Pasta("projeto");
projeto.adicionar(new Arquivo("README.md", 5));
// projeto.adicionar(src); // ERRO: não compila — Pasta não é Arquivo

// Cliente forçado a calcular manualmente
int total = projeto.getTamanho() + src.getTamanho(); // 25 KB
```
