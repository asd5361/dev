package game;

public class GameManager {
	
	//게임시작
	public void gameStart() {
		// 포켓몬 선택
		PokemonManager pm = new PokemonManager();
		pm.selectPokemon();
		
		// 배틀하기
		BattleManager bm = new BattleManager();
		bm.battleStart();
		
		// 결과출력
	}

}







