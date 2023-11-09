package loop;

public class Main {

	public static void main(String[] args) {
		/*
		 * 반복문
		 * 
		 * while, for, do-while,
		 * break	: 현재 반복문 종료 
		 * continue	: 
		 */
		
		/*
		 * [while] 문법
		 * while(조건){실행내용}
		 * 
		 * [for] 문법
		 * for(초기식;조건식;증감식){실행내용}
		 * 
		 * [do-while] 문법
		 * do{실행내용}(조건식);
		 */
		
//		int x = 0;			//초기식
//		while(x < 3) {		//조건식
//			System.out.println("안녕");	
//			x++;			//증감식
//		}
//		for(int i=0; i<3; i++) {
//			System.out.println("안녕");
//		}
//		int x = 0;
//		do {	
//			System.out.println("안녕");
//			x++;
//		}while(x<3);
		
//		int x = 0;
//		while(x < 4) {
//			System.out.println("안녕");
//			if(x == 1) {
//		//		continue;
//			}
//			System.out.println("바이");
//			x++;
//		}
		for(int x=0; x<3; x++) {
			System.out.println("안냥");
			if(x==1) {
				continue;
			}
			System.out.println("잘가");
		}
		
		
	}//main

}//class
