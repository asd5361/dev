package main;

public class Main {

	public static void main(String[] args) {

		System.out.println("generic =====");
		
		Mybox<Integer> mybox = new Mybox<Integer>();
		
		mybox.data = 123;
		
		System.out.println(mybox.data);
		
	}

}
