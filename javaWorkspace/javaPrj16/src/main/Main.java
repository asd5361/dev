package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		int cnt = 0;
		
		UpdownGame ug = new UpdownGame();	//객체 준비

		ug.printStarMsg();
		ug.printGameInfo();
		
		int answer =ug.prepareRandomAnswer();//정답 준비 (랜덤값)
		
		boolean isFinish = false;
		while(!isFinish){
			int num = ug.scanUserInput(); 	//유저 입력
			cnt++; 							//score 카운트
			//판단하고 정답 여부 리턴하기 (업 /다운 /정답)
			isFinish = ug.judgeUpDown(answer,num);
		}
		//스코어 출력
		System.out.println("시도 횟수: "+ cnt);
	}

}
