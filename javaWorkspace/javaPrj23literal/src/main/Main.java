package main;

public class Main {

	public static void main(String[] args) {

		String s2 = "Hello";
		String s1 = new String("Hello");
		String s3 = new String("Hello");
		String s4 = "Hello";
		
		System.out.println(s2 == s1);
		System.out.println(s2 == s3);
		System.out.println(s2 == s4);
		
		System.out.println(s2.equals(s1));
		
				
	}

}
