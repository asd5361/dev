package main;

import mob.Pokemon;

public class Main {

	public static void main(String[] args) {

		Pokemon p = new Pokemon();
		
		p.setName("파이리");
		p.setHp(1005);
		p.setAtk(55);
		
		Pokemon pp = new Pokemon("꼬부기",1000,70);

		String str = p.getFieldInfo();
		System.out.println(str);
		
	}

}
