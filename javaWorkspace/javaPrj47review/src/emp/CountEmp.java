package emp;

import java.util.*;

import menu.Burger;

public class CountEmp {

	
	//버거 메뉴 소개
	public void ShowBurgerMenu(List<Burger> burgerList) {
		//모든 버거 메뉴 출력
		for(Burger burger : burgerList) {
			System.out.println(burger);
		}
	}
	
	
}
