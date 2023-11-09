package util;

public class MyUtil {
	//특정 범위의 랜덤값 얻어오기
	public static int getRandomInt(int start,int end) {
		if(start > end){
			System.out.println("잘못된 범위입니다.");
			return -1;
		}
			int range = end - start + 1;
		
		return (int)(Math.random()*range+start); 
		
	}
}
