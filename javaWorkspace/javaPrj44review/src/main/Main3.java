package main;

import java.util.*;


public class Main3 {

	public static void main(String[] args) {

//		여러 개의 객체를 관리할 컬렉션
		Set<User> s = new HashSet<User>();
		
//		유저 객체 여러개 만들기
		s.add(new User("user01","1111"));
		s.add(new User("user02","2222"));
		s.add(new User("user03","3333"));
		
//		컬렉션에 들어있는 여러개의 객체 전부 다 출력 (모든 필드 값)
		System.out.println(s);
		
//		여러개의 객체 전부 다 출력 (객채의 name 필드만 출력)
//		여러개의 객체 전부 다 출력 (객체의 price 필드만 출력)
		for(User elem : s) {
			System.out.println(elem.getId());
			System.out.println(elem.getPwd());
		}
		
		
		
	}

}
