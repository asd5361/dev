package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * client 마다 생성
 * 읽어서 msgQueue 에 집어넣는다.
 */
public class ServerReader implements Runnable {
	
	private final BufferedReader br;

	public ServerReader(BufferedReader br) {
		this.br = br;
	}

	@Override
	public void run() {
		try {
			while(true) {
				String msg = br.readLine();
				ServerMain.msgQueue.offer(msg);
				Thread.sleep(1);
			}
		} catch (IOException | InterruptedException e) {
			System.err.println("=====Server Reader 예외 발생=====");
			System.err.println(e.getMessage());
			e.printStackTrace();
			System.err.println("-------------------------------");
		}
	}

}