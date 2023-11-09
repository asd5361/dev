package data;

public class Person {

	//멤버 변수
	private String name;
	private int age;
	private char gender;
	
	public Person(String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	//기본 생성자
	public Person() {
		
	}
	
	//멤버 메소드
	public void breath() {
		System.out.println("후-하, 후-하");
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		if(name.length() <2 || name == "") {
			System.out.println("잘못된 이릅 입니다.");
		}else {
			this.name = name;
		}
		
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		if(age < 0 || age < this.age) {
			System.out.println("잘못된 나이입니다.");
		}else {
			this.age = age;
		}
	}


	public char getGender() {
		return gender;
	}


	public void setGender(char gender) {
		if(gender == 'M' || gender == 'F') {
			this.gender = gender;
		}else {
			System.out.println("잘못된 성별입니다.");
		}
	}

	public String getFieldInfo() {
		return "Person [name="+this.name + ", age=" + this.age + ", gender=" + this.gender + "]";
	}

	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}

	
	
	
	
	
	
	
}//class
