package codeup;

import java.util.Scanner;

public class Main1411 {

	public static void main(String[] args) {
	//1411 문제
		
		//스캐너 준비
		Scanner sc = new Scanner(System.in);
		
		//N 입력받기 (최초 들고 있던 카드 갯수)
		int n = sc.nextInt();//5
		
		//원래 내 카드 정보 알 수 있음 (1~N)
		int[] arr = new int[n+1];// 6개 [전체]
		
		//현재 들고 있는 카드 확인 (입력 받기 n-1번)
		for(int i=0; i<n-1;i++) {// 5번 [횟수]
			int card = sc.nextInt();
			//확인한 카드 체크
			arr[card] = 1;
		}
		
		//결과 출력 (빠진 카드가 몇번 카드 인지)
		for(int i=1; i<n+1;i++) { // 5개 [가지고 있는 개수] 입력 받는 수는 1번부터니까 0은 필여 없음
			if(arr[i] == 0 ) {
				System.out.println(i);
			}
		}

	}//main

}//class
