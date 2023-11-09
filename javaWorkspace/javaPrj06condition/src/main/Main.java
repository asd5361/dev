package main;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("조건문 ~~~");
		
		/*
		 * <조건문>
		 * -조건 맞으면 코드 실행
		 * -if, else, else if
		 * 
		 * [문법]
		 * if(조건식){ 명령; }
		 * else if(조건식){명령~~~}
		 * else{명령~~~}
		 */
		
//		
//		int age = 10;
//		if(age >= 20) {
//		System.out.println("성인입니다.");
//		}
//		else { System.out.println("미성년자 입니다.");
//		
//		}
		
		
		int num = 0;
		if (num > 0) {
		System.out.println("양수");
		}else if(num <0){
		System.out.println("음수");
		}else {
			System.out.println("zero");
		}

		
		int age = 20;
		if (age < 20) {System.out.println("미성년자 입니다.");
		}else {System.out.println("성인 입니다.");
		}
		
		
		int score = 90;
		if (score < 50) {System.out.println("낙제");
		}else if(score>=80) {System.out.println("통과");
		}else {System.out.println("재시험");
		}
		
		
		int stdH = 177;
		if (stdH < 160) {System.out.println("작다");
		}else if(stdH > 180){System.out.println("크다");
		}else {System.out.println("보통");
		}
		
		
		
		
		
		
		
		
		
		
	}

}
