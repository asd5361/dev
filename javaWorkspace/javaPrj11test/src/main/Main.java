package main;


import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*
		 * 비만도 계산
		 *
		 * 키, 몸무게 입력 받기
		 * 표준몸무게 구하기
		 * BMI 구하기
		 * 결과 출력
		 */
		
		Scanner sc = new Scanner(System.in);
		//키와 몸무게 입력
		double height = sc.nextDouble();
		double weight = sc.nextDouble();
		
		//표준 몸무게
		double stdWeight;
		
		if(height<150) {
			stdWeight = height - 100;
		}else if(height >= 150 && height <160) {
			stdWeight = (height-150) / 2 +50;
		}else {
			stdWeight = (height-100)* 0.9;
		}
		
		//BMI 구하기
		double bmi = (weight-stdWeight)*100/stdWeight;
		
		//결과 출력
		if(bmi<=10) {
			System.out.println("정상");
		}else if(bmi <=20) {
			System.out.println("과체중");
		}else {
			System.out.println("비만");
		}
		
	}

}
