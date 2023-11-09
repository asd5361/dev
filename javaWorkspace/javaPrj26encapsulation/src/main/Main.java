package main;

import data.*;

public class Main {

	public static void main(String[] args) {

		System.out.println("=====캡술화=====");
		
//		Person p1 = new Person();
//		p1.setName("홍길동");
//		p1.SetAge(20);
//		
//		System.out.println(p1.getName());
//		System.out.println(p1.getAge());
//		
//		System.out.println("안녕하세요 "+p1.getName() + "입니다. 저는" + p1.getAge() + "입니다.");
//		
		Pokemon p = new Pokemon();
		
		p.setName("피카츄");
		p.setHp(100);
		p.setAtk(30);
		p.printInfo();
		
		String s = p.toString();
		System.out.println(s);
	}

}
