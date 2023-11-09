package manager;

import java.util.Scanner;

import main.Main;
import mob.Pokemon;

public class PokemonManager {
	
	//포켓몬 선택
	public void selectPokemon() {
		//포켓몬 생성
		generatePokemon();
		
		//포켓몬 정보 출력
		printPokemonInfo();
		
		//유저한테 입력받기
		int num = scanUserInput();
		
		//입력받은 정보를 이용하여 유저 포켓몬 준비
		setUserPokemon(num);
		
		//적 포켓몬 준비
		setEnemyPokemon();
	}
	
	private void setEnemyPokemon() {
		int random = (int)(Math.random()*3+1);
		switch(random){
		case 1 : Main.enemyPokemon = Main.p1; break;
		case 2 : Main.enemyPokemon = Main.p2; break;
		case 3 : Main.enemyPokemon = Main.p3; break;
		}
		
	}

	private void setUserPokemon(int num) {

		switch(num){
		case 1 : Main.userPokemon = Main.p1; break;
		case 2 : Main.userPokemon = Main.p2; break;
		case 3 : Main.userPokemon = Main.p3; break;
		default : System.out.println("잘못 입력하였습니다.");
		}
		
	}

	public int scanUserInput() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		return n;
	}

	private void printPokemonInfo() {
		
		System.out.println("원하시는 포켓몬을 선택하세요");
		System.out.println("=====포켓몬 목록=====");
		System.out.println(Main.p1.toString());
		System.out.println(Main.p2.toString());
		System.out.println(Main.p3.toString());
		System.out.println();	//줄바꿈 목적의 출력문
		System.out.println("원하는 포켓몬 번호를 입력하세요 : ");
		
	}

	private void generatePokemon() {
		Main.p1 = new Pokemon("피카츄",100,30,5);
		Main.p2 = new Pokemon("파이리",90,35,3);
		Main.p3 = new Pokemon("꼬부기",110,30,10);
	}

}
