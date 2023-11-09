package practice;

public class MethodTest {

	/*
	 * 메소드 : 명령어 모아 놓은 거
	 * 
	 * 명명 : 동사형태로 작성 , camelCase
	 * 
	 *   - 하나의 동작만 수행하는게 좋음 (가능한 작은 단위)
	 *   - 메소드 이름을 보고 내용을 파악하기 쉽게 작성하기
	 * 
	 * [문법]
	 * public void test() {~~~}
	 * 
	 * 기본 :
	 * 접근제한자 리턴타입 메소드명(){~~~}
	 * 
	 * 데이터을 받는:
	 * 접근제한자 리턴타입 메소드명(매개변수, ...){~~~}
	 * 
	 * 데이터을 반환하는:
	 * 접근제한자 리턴타입 메소드명(){~~; return 값;}
	 * 
	 * 데이터을 받고, 반환도 하는:
	 * 접근제한자 리턴타입 메소드명(매개변수, ...){~~; return 값;}
	 * 
	 * 
	 */
	
	//기본
	public void test() {
		System.out.println("~~~~~~");
	}
	
	//매개변수 있는 (1개)
	public void test01(int x) {
		System.out.println(x);
	}
	//매개변수 있는 (2개)
	public void test02(int a,int b) {
		int result = a+b;
		System.out.println(result);
	}
	
	//리턴값이 있는 (리턴값 여러개 불가능)
	public int test03() {
		return 123;
	}
	//매개변수 있는, 리턴값이 있는
	public int test04(int a, int b) {
		int result = a+b;
		return result;
	}
	//매개변수 == 파라미터 , 파라미터로 들어가는 값을 인자(argument)값이라고 칭함
}
