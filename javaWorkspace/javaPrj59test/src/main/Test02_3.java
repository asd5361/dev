package main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintStream;

import kh.model.vo.Food;

public class Test02_3 {

	public static void main(String[] args) {

		Test02_3 test02_3 = new Test02_3();
		
		try {
			test02_3.fileSave("D:\\dev\\test.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void fileSave(String fileName) throws Exception {
		//파일객체준비
		File f = new File(fileName);
		
		//내보낼 스트림 얻기
		FileWriter fw = new FileWriter(f);
		
		//객체 만들기
		Food food = new Food("사과",20);
		
		//내보내기
		fw.write(food.toString());
		fw.flush();
		fw.close();
		
		//파일출력스트림

		//객체 출력 스트림
//		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

	}

}
