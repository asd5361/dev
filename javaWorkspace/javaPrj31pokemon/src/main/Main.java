package main;

import manager.*;
import mob.Pokemon;

public class Main {

	public static Pokemon p1;
	public static Pokemon p2;
	public static Pokemon p3;
	public static Pokemon userPokemon; 
	public static Pokemon enemyPokemon; 
	
	
	public static void main(String[] args) {

		System.out.println("===========포켓몬============");
		
		BattleManager battleManager = new BattleManager();
		PokemonManager pokemonManager = new PokemonManager();
		
		//포켓몬 선택
		pokemonManager.selectPokemon();
		
		// 배틀 시작
		battleManager.startBattle();
	}

}
