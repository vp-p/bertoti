import java.util.LinkedList;
import java.util.List;

public class Stock {

	private List<Product> products = new LinkedList<Product>();
	
	public List<Product> getProduct(){
		return this.products;
	}
	public void addProduct(Product product) {
		products.add(product);
	}
	
	public List<Product> searchProduct(String name){
		List<Product> productsFound = new LinkedList<Product>();
		for (Product product:products) {
			if (product.getName().equals(name)) productsFound.add(product);
		}
		return productsFound; 	
	}
}
