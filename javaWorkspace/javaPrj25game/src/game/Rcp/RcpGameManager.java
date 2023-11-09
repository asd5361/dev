package game.Rcp;

import main.Main;

public class RcpGameManager {
	
	public void startGame() {
		//정답을 준비 (랜덤 1~100)
		int answer = (int)Math.random()*3+1;
		String computer =null;
		if(answer == 1){
			computer = "가위";
		}else if(answer == 2) {
			computer = "바위";
		}else {
			computer = "보";
		}
		System.out.print("가위 / 바위 / 보 중 선택해주세요 : ");
		
		//유저 입력 받기
		String user = Main.scanUserInput();
		
		//판단 //상대 꺼랑 비교
		if(computer.equals(user)) {
			System.out.println("비겼습니다.");
		}else if(computer.equals("가위")&&user.equals("보")
				 || computer.equals("바위")&&user.equals("가위")
				 || computer.equals("보")&&user.equals("바위")
				) {
			System.out.println("졌습니다.");
		}else {
			System.out.println("이겼습니다.");
		}
	}

}
