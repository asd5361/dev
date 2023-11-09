package main;

import game.GameManager;
import mob.Pokemon;

public class Main {
	
	public static Pokemon p1;
	public static Pokemon p2;
	public static Pokemon p3;
	public static Pokemon userPokemon; 
	public static Pokemon enemyPokemon; 

	public static void main(String[] args) {
		
		System.out.println("=====포켓몬 골드=====");
		
		// 게임시작
		GameManager gm = new GameManager();
		gm.gameStart();
		

	}//main

}//class

































