import model.Estoque;
import model.Produto;
import view.ListaProdutosView;
import controller.EstoqueController;
import controller.DescontoPercentual;
import controller.DescontoFixo;

public class Main {
    public static void main(String[] args) {

        Estoque estoque = new Estoque();

        ListaProdutosView view = new ListaProdutosView("Catalogo de Produtos");
        estoque.adicionarObservador(view);

        EstoqueController controller = new EstoqueController(estoque);

        System.out.println("=== Adicionando produtos ===");
        controller.adicionarProduto(new Produto("Notebook", 2500.00));
        controller.adicionarProduto(new Produto("Mouse", 150.00));
        controller.adicionarProduto(new Produto("Teclado", 200.00));

        System.out.println();
        view.renderizar();

        System.out.println("\n=== Aplicando desconto de 10% ===");
        controller.setEstrategiaDesconto(new DescontoPercentual(10));
        controller.aplicarDesconto();
        System.out.println();
        view.renderizar();

        System.out.println("\n=== Trocando estrategia: desconto fixo de R$ 50,00 ===");
        controller.setEstrategiaDesconto(new DescontoFixo(50));
        controller.aplicarDesconto();
        System.out.println();
        view.renderizar();
    }
}
