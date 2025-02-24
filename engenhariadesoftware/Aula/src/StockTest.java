import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.List;

public class StockTest {
	
	@Test
	void test() {
		Stock stock = new Stock();
		stock.addProduct(new Product("Coca-Cola", "456"));
		stock.addProduct(new Product("Cheetos", "798"));
		
		assertEquals(stock.getProduct().size(), 2);
		
		List<Product> productsFound = stock.searchProduct("Cheetos");
		
		assertEquals(productsFound.get(0).getCode(), "798");
		
	}
}
