package manager;

import main.Main;
import mob.Pokemon;
import util.MyUtil;

public class BattleManager {

	public void startBattle() {
		boolean isFinish = false;
		
		//유저 vs 적
		
		//두 포켓몬의 정보 출력
		printPokemonInfo();
		while(true) {
			
			// 유저 행동 입력받기 (1. 몸통 박치기 2. 스킬)
			int num = scanUserAction();
			
			//입력값에 따라 공격
			isFinish =  fight(Main.userPokemon, Main.enemyPokemon, num);
			if(isFinish) {
				//결과 출력
				System.out.println("유저 승리!");
				//배틀 종료
				System.out.println("배틀 종료===============");
				return;
			}
			
			// 적 행동 랜덤으로 진행 (1. 몸통 박치기 2. 스킬)
			isFinish =  fight(Main.enemyPokemon, Main.userPokemon, MyUtil.getRandomInt(1, 2));
			if(isFinish) {
				//결과 출력
				System.out.println("유저 패배!");
				//배틀 종료
				System.out.println("배틀 종료===============");
				return;
			}
		}
		
	}

	private int scanUserAction() {
		//행동 목록 보여주기
		printActionList();
		
		//유저 입력 받기
		int num = Main.sc.nextInt();
		
		return num;	
		
	}

	private boolean fight(Pokemon attacker, Pokemon defender, int num) {
		
		//공격 메소드 호출
		switch(num) {
		case 1 :
			attacker.bodyAttack(); break;
		case 2 :
			attacker.skill(); break;
		}
		
		//데미지 계산
		int dmg = attacker.getAtk()*num - defender.getDef();	
		System.out.print(attacker.getName()+"의 공격 데미지 : " + dmg +" , ");	
		
		//체력감소
		defender.setHp(defender.getHp() - dmg);
		System.out.println(defender.getName()+"의 남은 체력 : " + defender.getHp()+"\n");
			
		//죽었는지 체크
		if(defender.getHp() <= 0) {
			return true;
		}else {
			return false;
		}
	}

	private void printActionList() {
		System.err.println("원하시는 동작의 번호를 입력하시오==========");
		System.out.println("1. 몸통 박치기");
		System.out.println("2. 스킬 사용\n");
	}

	private void printPokemonInfo() {
		
		System.out.print("유저 : ");
		System.out.println(Main.userPokemon.toString());
		
		System.out.print("적  : ");
		System.out.println(Main.enemyPokemon.toString());
		
	}

}
