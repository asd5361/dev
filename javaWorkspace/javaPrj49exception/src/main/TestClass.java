package main;

public class TestClass {

	public void method01() {
		System.out.println("method 01 start ~ !");
		method02();
		System.out.println("method 01 end ... !");
	}
	public void method02() {
		System.out.println("method 02 start ~ !");
		int[] arr = new int[3];
		
		try {
			//예외가 발생할 것으로 의심되는 코드
			System.out.println(11111);
//			arr[7] = 10;
			int x = 3/0;
			System.out.println(22222);
		}catch(Exception x){
			//예외를 잡아서 처리할 내용
			System.out.println("예 외 발 생");
			System.out.println(x);
			
		}
//		catch(ArithmeticException y) {
//			System.out.println("0으로 나누려는거 잡았다");
//		}
		
		method03();
		System.out.println("method 02 end ... !");
	}
	public void method03() {
		System.out.println("method 03 start ~ !");
		System.out.println("method 03 end ... !");
	}
	
}
