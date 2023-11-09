package server;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ServerMain {

	//server 소켓
	public static void main(String[] args) throws Exception {
		
		//스캐너 준비
		Scanner sc = new Scanner(System.in);
		
		System.out.println("=======서버========");
		
		//ServerSocket : 서버 소켓 생성 (연결 대기)
		ServerSocket serverSocket = new ServerSocket(12345);
		
		//Socket : 일반 소켓 , 연결 대기하기 
		System.out.println("연결 대기중 ...");
		Socket socket = serverSocket.accept();
		InetAddress inetAddr = socket.getInetAddress();
		System.out.println(inetAddr + "연결됨 !");
		
			// 소켓 스트림 준비
		InputStream inputStream = socket.getInputStream();
		OutputStream outputStream = socket.getOutputStream();
			// 데이터 수신(통로)
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		
			//데이터 발신 (통로)
		PrintStream ps = new PrintStream(outputStream);
		
		while(true) {
			//데이터 읽기
			String str = bufferedReader.readLine();
			System.out.println("상대(클라이언트)가 보낸 메세지 : "+str);
			
			//데이터 보내기
			System.out.print("내(서버)가 보낼 메세지 :");
			String msg = sc.nextLine();
			ps.println(msg);
		}
		
	}

}
