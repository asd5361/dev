package game;

import main.Main;
import mob.Pokemon;

public class BattleManager {
	
	Pokemon enemyPokemon;	//적 포켓몬 

	//배틀 : 유저가 선택한 포켓몬 vs 랜덤 적 포켓몬
	public void battleStart() {
		//랜덤으로 적 포켓몬 선택
		selectRandomEnemy();
		//유저포켓몬과 적 포켓몬 배틀
		Pokemon winner = null;
		while(true) {
			winner = fight(Main.userPokemon , Main.enemyPokemon);
			if(winner != null) {break;}
			winner = fight(Main.enemyPokemon , Main.userPokemon);
			if(winner != null) {break;}
		}
		
		//승자 출력
		System.out.println(winner.getName() + " 의 승리!");
		
	}

	public Pokemon fight(Pokemon attacker, Pokemon defender) {
		//attacker 가 공격
		attacker.bodyAttack();	//ㅇㅇㅇ 의 몸통박치기 !
		int damage = attacker.getAtk() - defender.getDef();	//데미지 계산
		System.out.println("데미지 : " + damage);
		defender.setHp(defender.getHp() - damage);	//데미지 적용
		System.out.println(defender.getName() +" 의 남은 체력 : " + defender.getHp());
		
		//defender 가 죽었는지 판단. 죽었으면 승자 리턴.
		if(defender.getHp() <= 0) {
			return attacker;
		}else {
			return null;
		}
	}

	public void selectRandomEnemy() {
		//랜덤값에 따라 enemyPokemon 에 값 셋팅
		//enemyPokemon 은 다른 메소드에서도 쓰일 예정이므로 멤버변수로 만듦
		
		//1~3 사이의 랜덤 값 준비
		int random = (int) (Math.random() * 3 + 1);
		
		//랜덤값에 따라 적 포켓몬 준비
		switch(random) {
		case 1 : Main.enemyPokemon = Main.p1; break;
		case 2 : Main.enemyPokemon = Main.p2; break;
		case 3 : Main.enemyPokemon = Main.p3; break;
		default : System.out.println("잘못 입력하셨습니다.");
		}
	}
	
	

}
