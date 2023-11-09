package manager;

import main.Main;
import mob.Pokemon;

public class BattleManager {
	
	
	//배틀 시작
	public void startBattle() {
		
		int userHp = Main.userPokemon.getHp();
		int enemyHp = Main.enemyPokemon.getHp();
		
		//번갈아가면서 공격
		boolean isDead = false;
		
		
			while(!isDead) {
				//데미지 계산
				Pokemon attacker = Main.userPokemon;
				Pokemon defender = Main.enemyPokemon;
				
				int damage = calcDamage(attacker.getAtk(),defender.getDef());	
				System.out.println("데미지는 : " + damage);
				
				//체력 감소
				enemyHp = enemyHp - damage;
				System.out.println("남은 체력 : "+enemyHp);
				
				// 죽음 판단
				isDead = checkHp(enemyHp);
			}
		
		
		//결과 출력
		if(userHp <= 0) {
			System.out.println(Main.enemyPokemon.getName()+"승리");
		}else {
			System.out.println(Main.userPokemon.getName()+" 승리");
		}
		
	}

	private boolean checkHp(int enemyHp) {
		return enemyHp <= 0;
	}

	private int calcDamage(int atk, int def) {
		return atk - def;
	}
}
