package member;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MemberDao {
	
	//멤버변수 == 필드
	private File file;
	
	//기본생성자
	public MemberDao() {
		String fileName = "D:\\dev\\hello.txt";
		file = new File(fileName);
	}
	
	//회원가입 (데이터 집어넣기)
	public boolean join(MemberData memberData) {
		//파라미터로 받은 데이터를 저장공간(메모장)에 담기
		
		//파일 객체
		//보내는 스트림
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
			
			//데이터 가공		ID@PWD@NICK
			String dataStr = memberData.getId() + "@" + memberData.getPwd() + "@" + memberData.getNick(); 
			//보내기
			fw.write(dataStr);
			
		}catch(IOException e) {
			System.out.println("파일 객체 만드려다가 ,,, IO예외 발생함 ...");
			return false;
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				
			}
		}
		
		//결과리턴
		return true;
	}
	
	//로그인 (데이터 꺼내오기)
	public boolean login(MemberData memberData) {
		//저장공간(메모장)에서 데이터 꺼내기
		
		//파일 객체
		//받는 스트림
		BufferedReader br = null;
		FileReader fr = null;
		boolean isSuccess = false;
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			//읽기
			String str = br.readLine();
			
			//비교 (입력받은거 랑 꺼낸데이터)
			String id = memberData.getId();
			String pwd = memberData.getPwd();
			
			String memoId = str.substring(0, str.indexOf("@"));
			str = str.substring(str.indexOf("@")+1);
			String memoPwd = str.substring(0, str.indexOf("@"));
			
			isSuccess = memoId.equals(id) && memoPwd.equals(pwd);
		}catch(Exception e) {
			System.out.println("파일 못찾아서 예외 발생,,,,");
		}finally {
			try {if(fr != null) {fr.close();}}catch(Exception e) {}
			try {if(br != null) {br.close();}}catch(Exception e) {}
		}
		
		//결과리턴
		return isSuccess; 
	}

}
