package main;


public class Menu {
	
	private String name;
	private int price;

	public Menu() {
		
	}
	
	public Menu(String name, int price) {
		this.name = name;
		this.price = price;
	}

	String getName() {
		return name;
	}
	void setName(String name) {
		this.name = name;
	}
	int getPrice() {
		return price;
	}
	void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Menu [name=" + name + ", price=" + price + "]";
	}
	
	
}
