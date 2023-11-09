package manager;

import main.Main;
import mob.Pokemon;
import util.MyUtil;

public class PokemonManager {

	public void selectPokemon() {

		//포켓몬 목록 출력
		printPokemonList();
		
		//유저 입력
		int num = scanUserInput();
		
		//유저 포켓몬 생성
		setUserPokemon(num);
		
		//적 포켓몬 랜덤 생성
		setEnemyPokemon();
	}

	private void setEnemyPokemon() {
		int num = MyUtil.getRandomInt(1, 3);
		switch(num) {
		case 1:Main.enemyPokemon = new Pokemon(Pokemon.NAME01); break;
		case 2:Main.enemyPokemon = new Pokemon(Pokemon.NAME02); break;
		case 3:Main.enemyPokemon = new Pokemon(Pokemon.NAME03); break;
		}
		
	}

	private void setUserPokemon(int num) {
		switch(num) {
		case 1:Main.userPokemon = new Pokemon(Pokemon.NAME01); break;
		case 2:Main.userPokemon = new Pokemon(Pokemon.NAME02); break;
		case 3:Main.userPokemon = new Pokemon(Pokemon.NAME03); break;
		}
		
	}

	private int scanUserInput() {
		int num = Main.sc.nextInt();
		return num;
	}

	private void printPokemonList() {
		System.out.println("원하시는 포켓몬을 선택해주세요======");
		System.out.println("1. : " + Pokemon.NAME01);
		System.out.println("2. : " + Pokemon.NAME02);
		System.out.println("3. : " + Pokemon.NAME03);
		
	}

}
