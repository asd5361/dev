package data;

public class Person {
	
	// 캡슐화 실습
	// 이름, 나이
	private String name;
	private int age;
	
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age-1;
	}
	
	public void SetAge(int age) {
		if(age < 0) {
			System.out.println("X");
			return;
		}
		if(age < this.age) {
			System.out.println("XX");
			return;
		}
		this.age = age;
	}
	
	
	
}
