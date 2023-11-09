package main;

import java.util.prefs.BackingStoreException;

import battle.BattleManager;
import mob.Pokemon;
 
public class Main {

	public static void main(String[] args) {
		
		//포켓몬 배틀
		BattleManager b = new BattleManager();
		b.battleStart();
		
//		//포켓몬 객체 생성하고,해당 객체의 주소를 변수에 담기
//		Pokemon p = new Pokemon();
//		
//		//객체 안의 변수들에 값 넣기
//		p.name = "꼬부기";
//		p.hp = 1000;
//		p.atk = 20;
//		p.def = 100;
//		
//		//객체 안에 변수들 출력해보기
//		System.out.println("가랏! "+p.name+". 너로 정했다!");
//		//객체의 attack 메소드 호출하기
//		p.attek();
		
	}

}
