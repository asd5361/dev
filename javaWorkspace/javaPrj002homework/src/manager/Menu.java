package manager;

public class Menu {
	
	
	private String name;
	private char size;
	private int price;
	private int amount;
	
	public Menu(String name, int price) {
		this.name = name;
		this.size = 'L';
		this.price = price;
		this.amount = 1;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getSize() {
		return size;
	}
	public void setSize(char size) {
		this.size = size;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Menu [name=" + name + ", size=" + size + ", price=" + price + ", amount=" + amount + "]";
	}
	
	
	
}//Menu
