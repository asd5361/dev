package main;

import java.util.Random;
import java.util.Scanner;

public class Main {
	//업다운게임
	public static void main(String[] args) {
		
		System.out.print("업다운 숫자를 입력해주세요:");
		
		//시도 횟수
		int cnt = 0;
		
		//정답 숫자 준비
		int answer = (int)(Math.random()*100+1);
		
		while(true) {	
			
			//유저한테 입력받기
			Scanner sc = new Scanner(System.in);
			int x =sc.nextInt();
			
			//시도 횟수 증가
			cnt++;
			
			//판단
			if(x < answer) {
				System.out.println("업");
			}else if(x > answer) {
				System.out.println("다운");
			}else {
				System.out.println("정답입니다. 시도 횟수는"+cnt+"입니다.");
				break;
			}
		}
	}//main 끝

}
