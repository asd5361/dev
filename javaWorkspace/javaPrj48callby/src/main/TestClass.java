package main;

public class TestClass {

	public void method01(){
		System.out.println("m01 called");
		Person p = new Person();
		p.age = 20;
		method02(p);
		System.out.println(p.age);
	}
	
	public void method02(Person abc){
		System.out.println("m02 called");
		abc.age=10;
	}
	
}
