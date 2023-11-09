package main;

import java.util.Scanner;

import manager.BattleManager;
import manager.PokemonManager;
import mob.Pokemon;

public class Main {
	public static Pokemon userPokemon;
	public static Pokemon enemyPokemon;
	public static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("포켓몬ver0905=================");
		
		PokemonManager pokemonManager = new PokemonManager();
		BattleManager battleManager = new BattleManager();
		
		//포켓몬 선택
		pokemonManager.selectPokemon();
		
		// 배틀
		battleManager.startBattle();
		
		//프로그램 종료
		System.out.println("프로그램 종료");
		
	}
	

}
