package main;

import java.security.DrbgParameters.NextBytes;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		//정수 입력 받기 학생 3명의 성적 입력 받기
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("학생 수 : ");
		int n = sc.nextInt();
		
		int[] scoreArr = new int[n];
		
		//입력 받은 수 출력 각 학생의 성적을 출력하기
		for(int i = 0; i<scoreArr.length; i++) {
			System.out.print(i+1+" 번 학생 성적 : ");
			scoreArr[i] = sc.nextInt();
		}
		
		for(int i=0; i<scoreArr.length; i++) {
			System.out.print(scoreArr[i]+" ");
		}
		
		
		
	}//main

}
