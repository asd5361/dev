package client;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientSender implements Runnable {
	
	private final Socket socket;
	private final Scanner sc;

	public ClientSender(Socket s, Scanner sc) {
		this.socket = s;
		this.sc = sc;
	}



	@Override
	public void run() {
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"));
			while(true) {
				String msg = sc.nextLine();
				bw.write(ClientMain.name + msg);
				bw.newLine();
				bw.flush();
				Thread.sleep(1);
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

}