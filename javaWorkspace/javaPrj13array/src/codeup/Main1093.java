package codeup;

import java.util.Scanner;

public class Main1093 {
	//1093 문제
	public static void main(String[] args) {
		// 입력도구 준비
		Scanner sc = new Scanner(System.in);
		
		//배열 생성 (학생 수 :23명)
		int[] memo = new int[24];
		
		//입력 받기 (출석 몇 번 부를건지)
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			//입력 받기 (출석 번호들)
			int num = sc.nextInt(); //방금 선생님이 부른 출석번호
		
			//메모하기
			memo[num]++;
		}
		
		//결과 출력
		for(int i = 1; i <=23; i++) {
			System.out.print(memo[i]+" ");
		}
	}

}
