package main;

public class Main {

	public static void main(String[] args) {

		System.out.println("예외던지기 throws============");
		
		TestClass tc = new TestClass(); 
		try {
			tc.method01();
		} catch (Exception e) {
			System.out.println("main에서 잡음");
		}
	}

}
