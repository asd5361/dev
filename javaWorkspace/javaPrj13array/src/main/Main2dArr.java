package main;

public class Main2dArr {

	public static void main(String[] args) {
		
		//2차원 배열
		
		int[][] x = new int[3][3];
		int cnt = 0;
//		x[0][0] = 10;
//		x[0][1] = 20;
//		x[0][2] = 30;
//		x[1][0] = 40;
//		x[1][1] = 50;
//		x[1][2] = 60;
//		x[2][0] = 70;
//		x[2][1] = 80;
//		x[2][2] = 90;
		
//		System.out.println(x[0][0]);
//		System.out.println(x[0][1]);
//		System.out.println(x[0][2]);
//		System.out.println(x[1][0]);
//		System.out.println(x[1][1]);
//		System.out.println(x[1][2]);
//		System.out.println(x[2][0]);
//		System.out.println(x[2][1]);
//		System.out.println(x[2][2]);
		
		for(int i=0; i<x.length; i++) {
			for(int j=0; j<x.length;j++) {
				cnt++;
				x[i][j] = cnt * 10;
			}
		}
		
		for(int i=0; i<x.length; i++) {
			for(int j=0; j<x.length;j++) {
				System.out.print(x[i][j]+" ");
			}
		}
		
	}

}
