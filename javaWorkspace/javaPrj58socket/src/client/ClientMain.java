package client;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientMain {

	public static void main(String[] args) throws Exception {
		
		//스캐너 준비
		Scanner sc = new Scanner(System.in);
		
		System.out.println("======클라이언트======");
		String ip ="192.168.40.30";
		String ip2 = "1.212.197.130";
		String ip3 = "127.0.0.1";
		String ip4 = "localhost";
		String ip5 = "192.168.40.39";
		
		//소켓 연결 (발신)
		Socket socket = new Socket("192.168.40.30", 12345);
		
		//소켓 스트림 준비
		InputStream in = socket.getInputStream();
		OutputStream out = socket.getOutputStream();
		
		//스트림 준비 (발신)
		PrintStream printStream = new PrintStream(out);
		
		//스트림 준비 (수신)
		InputStreamReader inputStreamReader = new InputStreamReader(in);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		
		while(true) {
			
			//데이터 발신
			System.out.print("클라이언트(내)가 보낸 메세지 :");
			String msg = sc.nextLine();
			printStream.println(msg);
	
			//데이터 수신
			String rcvMsg = bufferedReader.readLine();
			System.out.println("상대(서버)가 보낸 메세지 : "+rcvMsg);
		}
		
	}
}
