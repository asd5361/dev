package main;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// 총 3번 arrayList 담에서 출력 하기 , set 이나 map등등 다른 거 2개 선택해서 해보기
		// 43번 프로젝트 클론 코딩으로 처보기
		System.out.println("복습================");

//		여러 개의 객체를 관리할 컬렉션
		List menuList = new ArrayList();
		
//		메뉴 객체 여러개 만들기
		menuList.add(new Menu("아메리카노",3000));
		menuList.add(new Menu("카페모카",3500));
		
		Menu menu1 = (Menu)menuList.get(0);
		Menu menu2 = (Menu)menuList.get(1);
		
//		여러개의 객체 전부 다 출력 (모든 필드 값)
		System.out.println(menuList.get(0));
		System.out.println(menuList.get(1));
		System.out.println(menuList.get(2));
		
//		System.out.println(menuList);
		
//		여러개의 객체 전부 다 출력 (객채의 name 필드만 출력)
		System.out.println(menu1.getName());
		System.out.println(menu2.getName());
		
//		여러개의 객체 전부 다 출력 (객체의 price 필드만 출력)
		System.out.println(menu1.getPrice());
		System.out.println(menu2.getPrice());
		
		
		
	}
//	for(int i=0;i<menuList.size();i++) {
//	Menu x = (Menu)menuList.get(i);
//	
//	System.out.println(x.getName());
//	System.out.println(x.getPrice());
//}

}
