package main;

import mob.Pairi;
import mob.Pikachu;
import mob.Pokemon;
import mob.Turtle;

public class Main {

	public static void main(String[] args) {

		System.out.println("포켓몬==============");
		
		Pokemon[] pokemonArr = new Pokemon[3];
		
		pokemonArr[0] = new Pikachu(100,30,10);
		pokemonArr[1] = new Pairi(100,25,8);
		pokemonArr[2] = new Turtle(105,18,11);
		
		for(int i =0; i < pokemonArr.length; i++) {
			//모든 포켓몬 정보(멤버변수 == 필드 == 객체변수 == 인스턴스변수) 확인
			System.out.println(pokemonArr[i]);
		}
		for(int i =0; i < pokemonArr.length; i++) {
			//모든 포켓몬 몸통박치기
			pokemonArr[i].bodyAttack();
		}		
			
		for(int i =0; i < pokemonArr.length; i++) {
			//모든 포켓몬 스킬
			pokemonArr[i].skill();
		}		
		
	}

}
