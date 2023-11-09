package main;

import java.util.*;

public class Main2 {

	public static void main(String[] args) {
	
//		여러 개의 객체를 관리할 컬렉션
		List<User> al = new ArrayList<User>();
		
//		유저 객체 여러개 만들기
		al.add(new User("hong01","1234"));
		al.add(new User("kim01","4321"));
		al.add(new User("lee01","0000"));
		
		
//		컬렉션에 들어있는 여러개의 객체 전부 다 출력 (모든 필드 값)
		System.out.println(al);
		
//		여러개의 객체 전부 다 출력 (객채의 name 필드만 출력)
//		여러개의 객체 전부 다 출력 (객체의 price 필드만 출력)
		
		for (User e : al) {
			System.out.println(e.getId());
			System.out.println(e.getPwd());	
		}
		
//		for(int i=0; i<al.size(); i++) {
//			User e = al.get(i);
//			System.out.println(e.getId());
//			System.out.println(e.getPwd());			
//		}
		

		
	}

}
