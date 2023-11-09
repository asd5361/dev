package car;

public abstract class Car {
	private int price;
	private int speed;
	private String color;
	
	public abstract void go();

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Car [price=" + price + ", speed=" + speed + ", color=" + color + "]";
	}
	
	
}
