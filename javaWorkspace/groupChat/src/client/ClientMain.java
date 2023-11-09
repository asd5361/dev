package client;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain {
	
	public static String name;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("사용자 이름 : ");
		ClientMain.name = "[" + sc.nextLine() + "] ";
		
		System.out.print("접속 ip : ");
		String ip = sc.nextLine();
		
		System.out.print("접속 port : ");
		String port_ = sc.nextLine();
		int port = Integer.parseInt(port_);
		
		try {
			Socket s = new Socket(ip, port);
			
			new Thread(new ClientSender(s , sc)).start();
			new Thread(new ClientReader(s)).start();
			
			System.out.println("===== 접속 완료 =====");
			
		} catch (IOException e) {
			System.err.println("=====Client Main 예외 발생=====");
			System.err.println(e.getMessage());
			e.printStackTrace();
			System.err.println("-------------------------------");
		}
		
		
		
	}

}