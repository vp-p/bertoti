# Arquitetura MVC com Padrões de Projeto

Demonstração prática da arquitetura **Model-View-Controller** integrando três padrões de projeto.
Cada camada da arquitetura aplica um padrão diferente, evidenciando como os padrões resolvem
problemas reais dentro de uma estrutura MVC.

| Camada | Padrão | Problema resolvido |
|---|---|---|
| **Model** | Observer | A View precisa ser notificada automaticamente quando os dados mudam |
| **View** | Composite | Componentes visuais simples e compostos devem ser tratados uniformemente |
| **Controller** | Strategy | O comportamento de negócio (desconto) deve ser trocável em tempo de execução |

---

## Diagrama Geral da Arquitetura

```
     CONTROLLER                   MODEL                       VIEW
  [Padrão Strategy]           [Padrão Observer]          [Padrão Composite]
                                                                    
+--------------------+    atualiza    +---------------+            
| EstoqueController  |-------------->| Estoque       |            
|                    |               | (Observavel)  |            
| - estrategia:      |               |               |            
|   EstrategiaDesconto|              | - produtos    |            
|                    |               | - observadores|            
| + adicionarProduto |               +---------------+            
| + aplicarDesconto  |                      | notifica            
+--------------------+                      | (Observer)          
         | usa                              v                     
         v                         +--------------------+        
+--------------------+             | ListaProdutosView  |        
| <<interface>>      |             | (Observador +      |        
| EstrategiaDesconto |             |  ComponenteView)   |        
+--------------------+             |                    |        
| + aplicar(List)    |             | + atualizar()      |        
+--------------------+             | + renderizar()     |        
         △                         +--------------------+        
         | implementa                        | compoe (Composite)
    _____|______                             v                    
   |            |                  +--------------------+        
+----------+ +--------+            | PainelView         |        
|Desconto  | |Desconto|            | (Composite)        |        
|Percentual| |Fixo    |            |                    |        
+----------+ +--------+            | - filhos: List<>   |        
                                   | + adicionar()      |        
                                   | + renderizar()     |        
                                   +--------------------+        
                                            | contém              
                                            v                    
                                   +--------------------+        
                                   | ItemProdutoView    |        
                                   | (Leaf)             |        
                                   |                    |        
                                   | + renderizar()     |        
                                   +--------------------+        
```

---

## MODEL — Padrão Observer

O `Estoque` é o **Publicador** (Subject): mantém a lista de produtos e notifica todos os
observadores registrados sempre que um produto é adicionado ou removido. A `View` se registra
como observador e reage automaticamente, sem que o Model precise conhecê-la diretamente.

```
+----------------------------+       +---------------------------+
|       <<interface>>        |       |       <<interface>>       |
|         Observavel         |       |         Observador        |
+----------------------------+       +---------------------------+
| + adicionarObservador()    |       | + atualizar(List<Produto>)|
| + removerObservador()      |       +---------------------------+
| + notificarObservadores()  |                    △
+----------------------------+                    | implementa
            △                                     |
            | implementa              +---------------------+
            |                        | ListaProdutosView   |
+------------------------------+     | (na camada View)    |
|          Estoque             |     +---------------------+
+------------------------------+
| - produtos: List<Produto>    |
| - observadores: List<Observador> |
+------------------------------+
| + adicionarProduto(Produto)  |-----notifica---> Observador
| + removerProduto(Produto)    |
| + notificarObservadores()    |
+------------------------------+

+---------------------+
|        Produto      |
+---------------------+
| - nome: String      |
| - preco: double     |
+---------------------+
| + getNome(): String |
| + getPreco(): double|
| + setPreco(double)  |
+---------------------+
```

---

## VIEW — Padrão Composite

A `View` é composta por uma árvore de componentes visuais. `PainelView` (Composite) agrupa
outros `ComponenteView`, inclusive outros painéis. `ItemProdutoView` (Leaf) é o elemento
terminal que renderiza um único produto. Ambos respondem à mesma interface `ComponenteView`,
permitindo que o código que chama `renderizar()` não precise distinguir folha de composto.

`ListaProdutosView` une os dois padrões: implementa `Observador` (recebe notificações do Model)
e `ComponenteView` (integra-se à árvore de componentes da View).

```
+-------------------------+
|      <<interface>>      |
|      ComponenteView     |
+-------------------------+
| + renderizar(): void    |
+-------------------------+
            △
            | implementa
     _______|___________
    |                   |
+------------------+  +------------------------+
| ItemProdutoView  |  |       PainelView       |
| (Leaf)           |  |      (Composite)       |
+------------------+  +------------------------+
| - produto: Produto|  | - titulo: String       |
+------------------+  | - filhos: List<        |
| + renderizar()   |  |     ComponenteView>    |
+------------------+  +------------------------+
                       | + adicionar(Componente)|
                       | + limpar()             |
                       | + renderizar()         |  <-- chama renderizar()
                       +------------------------+      em cada filho

+-------------------------------+
| ListaProdutosView             |
| implements ComponenteView,    |
|            Observador         |
+-------------------------------+
| - painel: PainelView          |
+-------------------------------+
| + atualizar(List<Produto>)    |  <-- recebido do Model (Observer)
| + renderizar()                |  <-- delega ao PainelView (Composite)
+-------------------------------+
```

---

## CONTROLLER — Padrão Strategy

O `EstoqueController` é o **Contexto**: delega o cálculo do desconto à estratégia configurada.
Trocar de `DescontoPercentual` para `DescontoFixo` em tempo de execução não requer nenhuma
alteração no Controller ou no Model — apenas uma nova implementação de `EstrategiaDesconto`.

```
+----------------------------------+
|       <<interface>>              |
|      EstrategiaDesconto          |
+----------------------------------+
| + aplicar(List<Produto>): void   |
+----------------------------------+
            △
            | implementa
     _______|__________
    |                  |
+------------------+ +-------------+
| DescontoPercentual| | DescontoFixo|
+------------------+ +-------------+
| - percentual:    | | - valor:     |
|     double       | |   double     |
+------------------+ +-------------+
| + aplicar()      | | + aplicar() |
+------------------+ +-------------+

+---------------------------------------+       usa       +-------------------+
|          EstoqueController            |---------------->| EstrategiaDesconto|
+---------------------------------------+                 +-------------------+
| - estoque: Estoque                    |
| - estrategia: EstrategiaDesconto      |
+---------------------------------------+
| + adicionarProduto(Produto): void     |
| + setEstrategiaDesconto(Estrategia)   |
| + aplicarDesconto(): void             |
+---------------------------------------+
```

---

## Fluxo completo da aplicação

```
  Main
   |
   |-- cria --> Estoque (Model)
   |-- cria --> ListaProdutosView (View)  --registra--> Estoque.adicionarObservador()
   |-- cria --> EstoqueController (Controller)
   |
   |-- controller.adicionarProduto(p)
   |       |
   |       +--> estoque.adicionarProduto(p)
   |                 |
   |                 +--> notificarObservadores()
   |                           |
   |                           +--> view.atualizar(produtos)   [Observer]
   |                                     |
   |                                     +--> reconstrói PainelView  [Composite]
   |
   |-- view.renderizar()  --> percorre árvore de ComponenteView [Composite]
   |
   |-- controller.setEstrategiaDesconto(new DescontoPercentual(10))
   |-- controller.aplicarDesconto()
   |       |
   |       +--> estrategia.aplicar(produtos)               [Strategy]
   |       +--> estoque.notificarObservadores()             [Observer]
   |                 |
   |                 +--> view.atualizar(produtos)
   |
   |-- view.renderizar()
```

---

## Participantes

| Classe | Camada | Padrão | Papel |
|---|---|---|---|
| `Observavel` | Model | Observer | Interface do publicador |
| `Observador` | Model | Observer | Interface dos assinantes |
| `Produto` | Model | — | Entidade de dados |
| `Estoque` | Model | Observer | Publicador concreto; notifica ao mudar |
| `ComponenteView` | View | Composite | Interface comum a folhas e compostos |
| `ItemProdutoView` | View | Composite | Folha: renderiza um produto |
| `PainelView` | View | Composite | Composto: agrupa ComponenteViews |
| `ListaProdutosView` | View | Observer + Composite | Observador concreto; raiz da árvore de view |
| `EstrategiaDesconto` | Controller | Strategy | Interface das estratégias |
| `DescontoPercentual` | Controller | Strategy | Estratégia concreta: desconto em % |
| `DescontoFixo` | Controller | Strategy | Estratégia concreta: desconto em valor fixo |
| `EstoqueController` | Controller | Strategy | Contexto: coordena model e estratégia |
| `Main` | — | — | Ponto de entrada; monta o MVC |

---

## Exemplo de uso [Main.java]

```java
Estoque estoque = new Estoque();

ListaProdutosView view = new ListaProdutosView("Catalogo de Produtos");
estoque.adicionarObservador(view);  // View observa o Model

EstoqueController controller = new EstoqueController(estoque);

controller.adicionarProduto(new Produto("Notebook", 2500.00));
controller.adicionarProduto(new Produto("Mouse",    150.00));
// view é notificada automaticamente a cada adição (Observer)

view.renderizar();
// +----------------------------------+
//   Catalogo de Produtos
// +----------------------------------+
//   - Notebook              R$ 2500,00
//   - Mouse                 R$ 150,00
// +----------------------------------+

controller.setEstrategiaDesconto(new DescontoPercentual(10));
controller.aplicarDesconto();  // troca de algoritmo em tempo de execução (Strategy)
                               // model notifica view automaticamente (Observer)

view.renderizar();
// +----------------------------------+
//   Catalogo de Produtos
// +----------------------------------+
//   - Notebook              R$ 2250,00
//   - Mouse                 R$ 135,00
// +----------------------------------+

controller.setEstrategiaDesconto(new DescontoFixo(50));
controller.aplicarDesconto();  // mesma chamada, comportamento diferente (Strategy)
```

---

## Como compilar e executar

```bash
# A partir do diretório mvc/
javac model/*.java view/*.java controller/*.java Main.java
java Main
```
