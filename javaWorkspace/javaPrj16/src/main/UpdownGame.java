package main;

import java.util.Scanner;

public class UpdownGame {

	public void printStarMsg() {
		System.out.println("==============================");
		System.out.println("|    Up & Dowm Game Start    |");
		System.out.println("==============================");
	}
	
	public void printGameInfo() {
		System.out.println("==============================");
		System.out.println("|   1~100 사이의 랜덤 숫자 맞추기   |");
		System.out.println("|      게임을 시작하겠습니다.       |");
		System.out.println("|     자연수만 입력 가능합니다.      |");
		System.out.println("|   정답을 맞출 때까지 반복됩니다.    |");
		System.out.println("|   마지막에 시도 횟수가 나옵니다.    |");
		System.out.println("==============================");
	}
	
	public int prepareRandomAnswer() {
		return (int)(Math.random() * 100 + 1);
	}
	
	public int scanUserInput() {
		System.out.print("번호를 입력하세요: ");
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	
	public boolean judgeUpDown(int answer,int num) { 
		//boolean형은 꼭 true와 false를 던져줘야한다.
		if(answer > num) {
			System.out.println("UP");
			return false;
		}else if(answer < num) {
			System.out.println("DOWN");
			return false;
		}else {
			System.out.println("ANSWER");
			return true;
		}
	}
	
}
