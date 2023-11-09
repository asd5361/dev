package main;

import mob.Pokemon;

public class Main {

	public static void main(String[] args) {
		
		Pokemon p = new Pokemon();
		p.name = "피카츄";
		p.hp = 100;
		p.atk = 30;
		p.def = 10;
		
		System.out.println(p.name);
		System.out.println(p.hp);
		System.out.println(p.atk);
		System.out.println(p.def);
		
		p.attack();

	}

}
