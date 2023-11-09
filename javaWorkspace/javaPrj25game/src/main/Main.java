package main;

import java.util.Scanner;

import game.GameManager;

public class Main {

	public static final Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("=======미니게임천국=======");
		
		GameManager gm = new GameManager();
		
		while(true) {
			//게임 정보 출력
			gm.printGameInfo();
			
			//게임 번호 입력 받기
			String userInput = scanUserInput();
			
			//게임 번호에 따라 게임을 시작
			switch(userInput) {
				case "1" : gm.startUpDown(); break;
				case "2" : gm.startRcp(); break;
				case "3" : gm.startPokemon(); break;
				case "9" : System.out.println("프로그램을 종료합니다."); return;
				default : System.out.println("잘못 입력하였습니다.");
			}
		}
		
	}//main
	
	public static String scanUserInput() {
		String x = Main.sc.nextLine();
		return x;
	}

}//class
