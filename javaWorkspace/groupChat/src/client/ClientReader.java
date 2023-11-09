package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class ClientReader implements Runnable {
	
	private final Socket socket;

	public ClientReader(Socket s) {
		this.socket = s;
	}

	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			while(true) {
				String msg = br.readLine();
				System.out.println(msg);
				Thread.sleep(100);
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

}