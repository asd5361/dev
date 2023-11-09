package main;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		/*가위바위보 게임*/
		
		System.out.println("게임을 시작하겠습니다.");
		
		String status = "";
		
		while(true) {
			
			//컴퓨터 패 준비
			int num = (int)(Math.random()*3+1);
			
			String com = "";
			
//			if(num == 1) {
//				com = "가위";
//			}else if(num == 2){
//				com = "바위";
//			}else {
//				com = "보";
//			}
			switch(num) {
				case 1 : com = "가위"; break;
				case 2 : com = "바위"; break;
				case 3 : com = "보"; break;
			}
			
			//유저 패 준비
			System.out.println("가위/바위/보를 선택해주세요");
			Scanner sc = new Scanner(System.in);
			String user = sc.nextLine() ;
			
			//유저 패 이상하면 다시 준비
			if(!user.equals("승리")&&!user.equals("가위")&&!user.equals("바위")&&!user.equals("보")) {
				System.out.println("잘못 입력하셨습니다. 다시 입력하세요");
				continue;
			}
			
			//판단 (문자열 비교 equals())
			if(com.equals(user)) {
				status = "draw";
			}else if((com.equals("가위")&& user.equals("바위"))
					||(com.equals("바위")&& user.equals("보"))
					||(com.equals("보")&& user.equals("가위"))
					|| (user.equals("승리"))){
				status = "win";
			}else if((com.equals("가위")&& user.equals("보"))
					|| (com.equals("바위")&& user.equals("가위"))
					|| (com.equals("보")&& user.equals("바위"))){
				status = "lose";
			}
			
			//판단 결과에 따라 출력문 실행
			System.out.println("=======유저:"+user+" 컴퓨터:"+com);
			if(status.equals("win")) {
				System.out.println("user Win");
				//재경기 희망 여부 체크
				System.out.println("다시 하시겠습니까? (yes/no)");
				Scanner sc2 = new Scanner(System.in);
				String reply = sc2.nextLine();
				if(reply.equals("no")) {
					break;
				}
				
			}else if(status.equals("lose")) {
				System.out.println("user lose");
			}else {
				System.out.println("Agin");
			}
			
		}//while
		
		System.out.println("=============게임종료=============");
	
	}//main

}//class
