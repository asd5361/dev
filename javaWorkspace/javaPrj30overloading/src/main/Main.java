package main;

import data.Member;
import data.Person;
import data.Pokemon;

public class Main {

	public static void main(String[] args) {
		System.out.println("생성자 오버로딩");
		
		//생성자를 이용한 초기화
//		Person p = new Person("양덕기",28);
//		System.out.println(p.getFidldInfo());
		
		//setter를 이용하여 객체 준비
		Person p = new Person();
		
		p.setName("양덕기");
		p.setAge(20);
		
		System.out.println(p);
		
		Pokemon pk = new Pokemon("피카츄",1000,55);
		System.out.println(pk);
		
		Member m = new Member("ccc","111","nick");
		System.out.println(m);
		
	}

}
