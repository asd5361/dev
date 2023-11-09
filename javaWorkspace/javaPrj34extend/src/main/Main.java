package main;

import mob.Pairi;
import mob.Pikachu;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("상속 연습 ===========");
		
		Pairi pairi = new Pairi();
		pairi.skill();
		pairi.bodyAttack();
		
		Pikachu pikachu = new Pikachu();
		
		pikachu.skill();
		pikachu.bodyAttack();
	}

}
