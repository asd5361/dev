package main;

import java.util.*;

import menu.Burger;

public class Main {

	public static void main(String[] args) {

		System.out.println("복습=======");
		
		//메뉴(햄버거) 준비
		Burger b1 = new Burger("치즈버거",5000);
		Burger b2 = new Burger("감자버거",4000);
		Burger b3 = new Burger("오이버거",300);
		
		//여러 객체 한번에 관리하기 (배열)
//		Burger[] burgerArr = new Burger[3];
//		burgerArr[0] = b1;
//		burgerArr[1] = b2;
//		burgerArr[2] = b3;
		
		//여러 객체 한번에 관리하기 (컬렉션)
		List<Burger> burgerArr = new ArrayList<Burger>();
		burgerArr.add(b1);
		burgerArr.add(b2);
		burgerArr.add(b3);
		
		//메뉴 보여주기 (기본 for문)
//		for(int i=0; i<burgerArr.length; i++) {
//			System.out.println(burgerArr[i]);
//		}
		
		//메뉴 보여주기 (향샹된 for문)
		for(Burger burger : burgerArr) {
			System.out.println(burger);
		}

		
//		System.out.println(b1);
//		System.out.println(b2);
//		System.out.println(b3);
		
		
	
	}

}
