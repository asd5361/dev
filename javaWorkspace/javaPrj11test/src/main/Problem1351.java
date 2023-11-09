package main;

import java.util.Scanner;

public class Problem1351 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();

//		for(int i=2; i<=9; i++) {
//			for(int j=1;j<10;j++) {
//				System.out.println(i+" * "+j+" = "+i*j);
//			}
//		}
		
		for(int dan=a; dan<=b; dan++) {
			for(int j=1;j<=9;j++) {
				System.out.println(dan+" * "+j+" = "+dan*j);
			}
		}
	}//main
}//class
