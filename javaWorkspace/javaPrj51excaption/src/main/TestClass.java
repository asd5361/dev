package main;

public class TestClass {

	public void method01() {
		System.out.println("method01 start ===");
		method02();
		System.out.println("method01 end ===");
	}
	public void method02() {
		System.out.println("method02 start ===");
		try {
//			throw new Exception("예외지롱"); 
			throw new KhException(); 
		} catch (Exception e) {
			System.out.println("예외발생");
			System.out.println(e.getMessage());
		}
		method03();
		System.out.println("method02 end ===");
	}
	public void method_02() {
		System.out.println("method02 start ===");
		try {
			System.out.println("!111");
			int x = 1/1;
			System.out.println("@222");
		} catch (Exception e) {
			System.out.println("에러발생");
//			System.out.println(e.getMessage());
//			e.printStackTrace();
		}finally {
			System.out.println("무조건 출력");
		}
		method03();
		System.out.println("method02 end ===");
	}
	public void method03() {
		System.out.println("method03 start ===");
		System.out.println("method03 end ===");
	}
}
