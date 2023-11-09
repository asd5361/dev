package member;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class MemberDao {
	
	//필드 == 멤버변수
	private File file;
	
	public MemberDao() {
		file = new File("D:\\dev\\hello.txt");
	}
	
	
	//회원가입		//파라미터로 전달받은 데이터 저장공간에 넣기
	public boolean join(MemberData memberData) throws Exception {
		//할일
		FileWriter fw = new FileWriter(file);
		
		String str = memberData.getId() + "#" + memberData.getPwd() + "#" + memberData.getNick();
		fw.write(str);
		
		fw.close();
		
		//결과 리턴
		return true;
	}
	
	//로그인		//파라미터로 전달받은 데이터랑 저장공간의 데이터랑 비교
	public boolean login(MemberData memberData) throws Exception {
		//할일
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		String memoStr = br.readLine();
		String memoId = memoStr.substring(0, memoStr.indexOf("#"));
		String memoPwd = memoStr.substring(memoStr.indexOf("#")+1 , memoStr.lastIndexOf("#"));
		
		boolean idOk = memoId.equals(memberData.getId());
		boolean pwdOk = memoPwd.equals(memberData.getPwd());
		
		boolean loginOk = idOk && pwdOk;
		
		//결과 리턴
		return loginOk;
	}
	
	

}//class