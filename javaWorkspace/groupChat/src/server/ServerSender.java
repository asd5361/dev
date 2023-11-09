package server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class ServerSender implements Runnable {
	
	Scanner sc = new Scanner(System.in);

	@Override
	public void run() {
		try {
			while(true) {
				Thread.sleep(1);
				String msg = ServerMain.msgQueue.poll();
				if(msg == null) continue;
				for(BufferedWriter bw : ServerMain.bwList) {
					bw.write(msg);
					bw.newLine();
					bw.flush();
				}
			}
		} catch (IOException | InterruptedException e) {
			System.err.println("=====Server Sender 예외 발생=====");
			System.err.println(e.getMessage());
			e.printStackTrace();
			System.err.println("-------------------------------");
		}
	}

}