package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//int 배열 생성. 5칸 짜리
		int[] arr = {100,200,300,400,500};
//		int[] arr = new int[5];
		
		//각 칸에 100,200,300,400,500 집어넣기
//		for(int i=0; i<arr.length; i++) {
//			arr[i] = 100*(i+1);
//		}
		
		//각 칸 값을 출력
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
