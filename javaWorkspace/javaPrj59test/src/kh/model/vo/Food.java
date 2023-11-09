package kh.model.vo;


public class Food {
	
	private String name;
	private int kcal;
	
	public Food(String name, int kcal) {
		this.name = name;
		this.kcal = kcal;
	}
	public Food() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKcal() {
		return kcal;
	}
	public void setKcal(int kcal) {
		this.kcal = kcal;
	}
	
	@Override
	public String toString() {
		return "Food [name=" + name + ", kcal=" + kcal + "]";
	}
	
	
}
