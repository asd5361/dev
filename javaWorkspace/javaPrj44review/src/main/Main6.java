package main;

import java.util.*;

public class Main6 {

	public static void main(String[] args) {

//		여러 개의 객체를 관리할 컬렉션
		HashMap<String,User> x = new HashMap<String,User>();
		
//		유저 객체 여러개 만들기
		x.put("user01", new User("user01","1212"));
		x.put("user02", new User("user02","1213"));
		x.put("user03", new User("user03","1214"));
		
//		컬렉션에 들어있는 여러개의 객체 전부 다 출력 (모든 필드 값)
		System.out.println(x);
		
		
//		여러개의 객체 전부 다 출력 (객채의 name 필드만 출력)
//		여러개의 객체 전부 다 출력 (객체의 price 필드만 출력)
		Set<String> ks = x.keySet();
		
		for(String k : ks) {
			System.out.println(k);
			User v = x.get(k);
			System.out.println(v);
		}
		
	}

}
