
public class Product {
	private String name;
	private String code;
	
	public Product(String name, String code) {
		this.name = name;
		this.code = code;
	}
	
	public String getName() {
		return  this.name;
	}
	
	public void setName(String name) {
		this.name = name;;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
}

