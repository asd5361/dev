package main;

import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {

		System.out.println("JDBCTemplate ");
		
		File f = new File("Info.txt");
		BufferedReader br = new BufferedReader(new FileReader(f));
		/*
		 * 위 1줄 코드와 같은 의미
		 * FileReader fr = new FileReader(f);
		 * BufferedReader br = new BufferedReader(fr);
		 */
		String url = br.readLine();
		String userName = br.readLine();
		String userPwd = br.readLine();
		
		System.out.println(url+userName+userPwd);
	}

}
