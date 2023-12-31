package review;

import java.security.PublicKey;

public class Review01 {

	
	public void method01() {
		//객체
		System.out.println("객체~~");
		/*
		 * 객체 : 데이터들의 집합, 변수와 메소드로 이루어진 그룹.
		 * 객체는 클래스를 바탕으로 만들어짐.
		 * 클래스의 멤버(변수+메소드)들을 바탕으로 만들어짐
		 * 
		 * 객체는 heap 메모리에 만들어진다.
		 * 
		 * 클래스 안에 작성된, static 변수 또는 static 메소드는 객체와 무관함.
		 * 
		 * 멤버(변수,메서드) 들은 객체가 태어나야만 존재함.
		 * 
		 * 클래스 파일은 객체를 생성하기 위한 설계도
		 * 
		 * 설계도 자체와 객체 자체는 서로 독립적이다.
		 * 
		 * 클래스(설계도)는 static에 메모리에 저장된 글자일 뿐.
		 * 객체는 Heap 메모리 안에 생성된 데이터 집합.
		 * 
		 */
		
		
	}
	public void method02() {
		//상속
		System.out.println("상속~~~");
		/*
		 * 객체는 부모객체가 만들어져야 본인이 태어날 수 있다.
		
		 * (JVM이 자동으로 작업을 해주고 있었음)
		 * 
		 * 상속 :부모 클래스에 작성된 내용을 자식 클래스도 가질 수 있다.
		 *		부모객체 + 자식객체 : 부모객체의 멤버를 자식도 쓸 수 있다.	
		 * 
		 * 생성자 : 부모 생성자를 호출함, 객체를 생성하여 리턴해준다. 기본 생성자, 매개변수가 있는 생성자
		 * 
		 * 어떤 생성자도 없으면 JVM이 기본 생성자를 만들어준다.
		 * 
		 * super, this
		 * 
		 * 상속은 여러 세대에 걸쳐서 상속도 가능하다.
		 * 
		 * instanceof 연산자 
		 * 
		 * 다형성 : 다양한 자료형(type)을 가지게 하는 것.
		 * 
		 * 자바는 클래스에 대해 단일 상속만 허용한다.
		 * (자식이 무조건 부모의 모든 메소드를 Override 한다는 보장이 없어서)
		 * 
		 * 인터페이스는 다중 상속이 가능하다.
		 * 
		 * 인터페이스는 일반적인 멤버가 없고 추상 메소드와 static 변수로 이루어졌습니다.
		 * 
		 * 인터페이스 끼리 상속이 가능하다.
		 * 
		 */
		
		
	}
}
