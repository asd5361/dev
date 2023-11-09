package main;

public class Test01 {

	// 변수
	public void hello() {
		
		byte   x   = 127;
		int    a   = 10;
		long   b   = 20;
		double d   = 3.14;
		boolean isOk = true;
		char ch = 'A';			//문자
		
		String str = "zzz";		//문자열 == 문자 배열
		
		System.out.println("hello ~~~~");
		
		/*
		 * 컴퓨터는 타임이 다르면 연산 불가
		 * 그래서 컴퓨터가 알아서 타입 변환 (auto casting)
		 * 
		 * 개발자가 강제로 타입 변환도 가능
		 * (변환시킬타임) 데이터;
		 * 
		 * 변수 명명 규칙 camelCase, 예약어X, 특수문자 $, _
		 * 
		 */
		
		System.out.println(x);
		System.out.println(a);
		System.out.println(b);
		System.out.println(d);
		System.out.println(ch);
		System.out.println(isOk);
		System.out.println(str);
		
	}
	
}
