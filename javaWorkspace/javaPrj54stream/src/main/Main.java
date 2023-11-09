package main;

import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {

		System.out.println("스트림============");
		
		File f = new File("D:\\dev\\Hello.txt");

		
//		f.delete();		//파일 삭제
		
//		FileOutputStream fos = new FileOutputStream(f);
//		fos.write(70);
		
//		FileWriter fw = new FileWriter(f);
//		fw.write("둠바라 두비두바두비두바");
//		fw.flush();

//		PrintStream ps = new PrintStream(f);
//		ps.println("테스트ㅎㅎ");
		
//		FileInputStream fis = new FileInputStream(f);
//		
//		for(int i = 0; i<3; i++) {
//			int result = fis.read();
//			char x = (char)result;
//			System.err.println(x);
//			
//		}
		
//		FileReader fr = new FileReader(f);
//		int result = fr.read();
//		System.out.println((char)result);
		
		BufferedReader br = new BufferedReader(new FileReader(f));
		String result = br.readLine();
		System.out.println(result);
		
		String result2 = br.readLine();
		System.out.println(result2);
		
		
	}

}
