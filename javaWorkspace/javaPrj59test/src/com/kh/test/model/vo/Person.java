package com.kh.test.model.vo;

public class Person {
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person() {
		super();
//		name = "oo";
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}
	
}
