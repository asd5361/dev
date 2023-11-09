
package car;

public class Car {
	
	public Car() {
		super();
	}


	int price;
	String color;
	int speed;
	

	public void accelerate() {
		System.out.println("차 굴러가유");
	}


	@Override
	public String toString() {
		return "Car [price=" + price + ", color=" + color + ", speed=" + speed + "]";
	}
	
	
}
