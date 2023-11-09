package battle;

import mob.Pokemon;

public class BattleManager {
	
	//멤버 변수
	String winner = null;
	
	Pokemon p1 = null;	
	Pokemon p2 = null;
	
	//포켓몬 생성 메소드
	public void generatePokemon() {
		p1 = new Pokemon();
		p1.name = "피카츄";
		p1.hp = 100;
		p1.atk =30;
		
		p2 = new Pokemon();
		p2.name = "파이리";
		p2.hp = 90;
		p2.atk =33;
		
	}
	
	//배틀시작 메소드
	public void battleStart() {
		
		//포켓몬 2마리 생성 //this. 은 현재 객체를 가리키므로 현재 객체의 멤버 메소드이다.
		generatePokemon(); 
		
		while(winner == null) {
			mobAttack(p1,p2);
			if(winner != null) {break;}
			mobAttack(p2,p1);
			if(winner != null) {break;}
		}
		
		//결과 출력
		System.out.println(winner+"이(가) 이겼습니다");
		
	}//battleStart()
	
	//멤버 메소드
	public void mobAttack(Pokemon attacker,Pokemon deffenser) {
		
		//번갈아가며 공격 //p2공격
		System.out.println(attacker.name + "이(가)"+deffenser.name + "를 공격함");
		//공격마다 데미지 계산하여 체력 수정 //p2공격
		deffenser.hp -= attacker.atk;
		
		//승패 판단
		if(deffenser.hp <= 0) {
			winner = attacker.name;
		}
	}//mobAttack()
	
	
}//class
