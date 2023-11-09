package main;

public class Run {

	public static void main(String[] args) {

		/*
		 * <변수>
		 * 
		 * 변수: 값을 저장하는 공간
		 * 
		 * [문법]
		 * 변수타입 변수명 = 값;
		 * 
		 * - 값 의미 파악 용이함
		 * - 여러곳에서 동일한 값을 사용하는 경우 관리가 편리함
		 * 
		 * -변수타입들
		 * -타입별 메모리 크기
		 * 
		 * 변수 명명 규칙
		 * - 예약어 사용 불가
		 * - 띄어쓰기 불가능
		 * - camelCase로 작성
		 */
		
		//정수: 기본이 int
		byte a = 127;
		System.out.println(a);
		
		short b = 20;
		System.out.println(b);
		
		int c = 30;
		System.out.println(c);
		
		long d = 40;
		System.out.println(d);
		
		//실수 : 기본이 double
		float f = 3.14f;
		System.out.println(f);
		
		double x = 3.14;
		System.out.println(x);
		
		//문자 (한글자) <=> 문자열: 문자배열 : 여러개의 문자
		//문자: 따옴표로 표현
		//문자열: 쌍따옴표로 표현
		char y = 'A';
		System.out.println(y);
		
		String s = "sdlfkajsdlk";
		System.out.println(s);
		
		
		//논리형
		boolean fl = false;
		System.out.println(fl);
	}

}
