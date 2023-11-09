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
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) throws Exception {
		if(price <= 0) {
			throw new Exception("가격은 0 이하일 수 없습니다.");
		}
		this.price = price;
	}
	
	@Override
	public String toString() {
		return name + " (" + price + "원)";
	}
	
}
