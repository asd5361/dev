package main;

public class Main {

	public static void main(String[] args) {

		System.out.println("Thread=========");
		
		Thread t0 = Thread.currentThread(); 				//현재 쓰레드를 얻어 올 수 있다.
															/* static 메소드이다.
															 * 현재 쓰레드를 리턴해준다.
															 * 
															 */

		String t0_name=t0.getName();
		System.out.println(t0_name);
		
		//쓰레드 생성
		Thread t1 = new Thread(new KhClass());
		t1.setName("내만쓰");										//만들어지고 실행되는 것을 뜻함. (create + run)
		t1.start();									//만들어지고 실행되는 것을 뜻함. (create + run)
		
	}

}
