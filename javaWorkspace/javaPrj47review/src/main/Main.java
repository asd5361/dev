package main;

import java.util.*;

import emp.CountEmp;
import menu.Burger;

public class Main {

	public static void main(String[] args) {

		System.out.println("복습=========");
		
		//버거 초기 셋팅
		List<Burger> burgerList = new ArrayList<>();
		burgerList.add(new Burger("치즈버거",5000));
		burgerList.add(new Burger("감자버거",4000));
		burgerList.add(new Burger("초코버거",3000));
		burgerList.add(new Burger("마늘버거",2000));
		burgerList.add(new Burger("갈릭버거",1000));
		
		System.out.println("메인 메소드에서 버거 리스트 출력");
		System.out.println(burgerList);
		
		//카운터 직원을 통해서, 모든 버거 메뉴 출력
		CountEmp cemp = new CountEmp();
		cemp.ShowBurgerMenu(burgerList);
		
		System.out.println("메인 메소드에서 버거 리스트 출력");
		System.out.println(burgerList);
		
	}

}
