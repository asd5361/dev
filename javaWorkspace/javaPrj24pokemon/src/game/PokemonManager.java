package game;

import java.util.Scanner;

import main.Main;
import mob.Pokemon;

public class PokemonManager {
	
	public void selectPokemon() {
		//포켓몬 목록 보여주기
		showPokemonList();
		// 유저입력받기
		int num = scanUserInput();
		// 입력번호에 맞게 포켓몬 기억하기
		setUserPokemon(num);
	}
	
	public void setUserPokemon(int x) {
		//전달받은 값에 따라 포켓몬을 선택하고
		//userPokemon 이라는 변수에 저장
		//userPokemon 변수는 앞으로 여기저기서 쓰일 예정이므로 
		//Main 클래스에 static 변수로 만들 예정
		// (Main 클래스 아니어도 되긴 함. static 으로 만드는게 중요.)
		
		switch(x) {
		case 1 : Main.userPokemon = Main.p1; break;
		case 2 : Main.userPokemon = Main.p2; break;
		case 3 : Main.userPokemon = Main.p3; break;
		default : System.out.println("잘못 입력하셨습니다.");
		}
	}

	public int scanUserInput() {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		return num;
	}

	public void showPokemonList(){
		//포켓몬 목록 생성
		generatePokemonList();
		//포켓몬 목록 출력
		printPokemonList(); 
	}
	
	public void generatePokemonList() {
		// 포켓몬 3마리 임의로 생성 
		// p1,p2,p3 변수는 다른 여러 곳에서 사용할 예정이므로 static 변수로 작성
		Main.p1 = new Pokemon();
		Main.p1.setName("피카츄");
		Main.p1.setHp(100);
		Main.p1.setAtk(30);
		Main.p1.setDef(5);
		Main.p2 = new Pokemon();
		Main.p2.setName("파이리");
		Main.p2.setHp(90);
		Main.p2.setAtk(35);
		Main.p2.setDef(3);
		Main.p3 = new Pokemon();
		Main.p3.setName("꼬부기");
		Main.p3.setHp(110);
		Main.p3.setAtk(23);
		Main.p3.setDef(10);
	}
	
	public void printPokemonList() {
		// 멤버변수 3개 출력 
		System.out.println("원하시는 포켓몬을 선택하세요");
		System.out.println("=====포켓몬 목록=====");
		System.out.println("1. " + Main.p1.getName());
		System.out.println("2. " + Main.p2.getName());
		System.out.println("3. " + Main.p3.getName());
		System.out.println();	//줄바꿈 목적의 출력문
		System.out.println("원하는 포켓몬 번호를 입력하세요 : ");
	}

}//class




























