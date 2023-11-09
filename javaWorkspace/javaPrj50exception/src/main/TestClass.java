package main;

public class TestClass {
	
	public void method01() throws Exception{
		System.out.println("method01 시작");
		
//		try {
			method02();
//		} catch (Exception e) {
//			System.out.println("메소드 01에서 잡았슴");
//		}
		
		System.out.println("method01 끝");
	}
	public void method02() throws Exception {
		System.out.println("method02 시작");
//		int x = 3/0; //예외가 발생하도록 유도
		throw new Exception(); //강제 예외를 발생시키면 밑에부터 읽지를 않아서 오류가 남
//		method03();
//		System.out.println("method02 끝");
	}
	public void method03() {
		System.out.println("method03 시작");
		System.out.println("method03 끝");
		
	}	

}
