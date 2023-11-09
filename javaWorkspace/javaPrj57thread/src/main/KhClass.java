package main;

public class KhClass implements Runnable {

	@Override
	public void run() {

		Thread x = Thread.currentThread();
		String str = x.getName();
		System.out.println(str);
	}

	
}
