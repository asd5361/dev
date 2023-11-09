package game.updown;

import game.GameManager;
import main.Main;

public class UpDownGameManager {
	
	public void startGame() {
		
		//시도 횟수
		int cnt = 0;
		
		//정답을 준비 (랜덤 1~100)
		int answer = (int)(Math.random()*100+1);
		
		while(true) {
			System.out.print("1~100 사이의 정수를 입력 : ");
			//유저 입력 받기
			String num_ = Main.scanUserInput();
			int num = Integer.parseInt(num_);
			cnt++;
			
			//판단 //업 다운 정답
			if(answer == num) {
				System.out.println("정답");
				break;
			}else if(num > answer) {
				System.out.println("DOWN");
			}else {
				System.out.println("UP");
			}
		}
		
		//시도횟수 출력
		System.out.println("시도 횟수 : "+cnt);
	}

}
