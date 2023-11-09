package data;

public class Person {
	
	public Person() {
		
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	private String name;
	private int age;
	
	public void breath() {
		System.out.println("숨 쉬는 중");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	
	
	
	
	
	
}
