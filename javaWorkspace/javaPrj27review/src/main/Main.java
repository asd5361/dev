package main;

import data.Person;

public class Main {

	public static void main(String[] args) {
		
		Person p = new Person("양덕기",28,'M');
		Person pp = new Person();
		pp.setName("덕기");
		pp.setAge(27);
		pp.setGender('M');

//		String str = pp.toString();
		String str = pp.getFieldInfo();
		System.out.println(str);
	}

}
