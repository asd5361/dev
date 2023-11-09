package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ServerMain {
	
	public static Queue<String> msgQueue = new LinkedList<>();
	public static List<BufferedWriter> bwList = new ArrayList<>(); 

	public static void main(String[] args) {
		
		try {
			ServerSocket serverSocket = new ServerSocket(12345);
			
			new Thread(new ServerSender()).start();
			
			while(true) {
				System.out.println("연결 대기중 ...");
				Socket socket = serverSocket.accept();
				System.out.println(socket.getInetAddress() + " 연결됨...");
				
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
				new Thread(new ServerReader(br)).start();
				
				bwList.add(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8")));
			}
			
		} catch (IOException e) {
			System.err.println("메인 쓰레드 죽음...");
			e.printStackTrace();
		}
		
	}//main

}//class