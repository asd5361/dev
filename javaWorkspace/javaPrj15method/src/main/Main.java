package main;

import java.util.Scanner;

public class Main {
	
	
	
	public static void main(String[] args) {
		
		System.out.println("==== 메소드 ====");
		
		/*
		 * 메소드 : 명령어 모아둔 것
		 * [문법]
		 * public  void     m01()   {실행내용}
		 * 접근제한자 리턴타임  메소드이름() {실행내용}
		 * 접근제한자 리턴타임  메소드이름(매개변수) {실행내용}
		 * 접근제한자 리턴타임  메소드이름(매개변수,매개변수 ...) {실행내용}
		 * 접근제한자 리턴타임  메소드이름(매개변수,매개변수 ...) {return 값;}
		 * 
		 */
		
		// 유저한다 입력 받은 값을 출력하는 메소드
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		MethodTest mt = new MethodTest();
		mt.printNumber(n);
		
	}//main end
}//class
	
	
//static을 사용하면 객체 생성을 하지 않아도 실행 할 수 있다. 객체에서는 호출이 불가능.
// 메모리에 한번 할당되므로 여러 객체가 해당 메모리를 공유하게 된다.

