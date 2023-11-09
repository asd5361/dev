package main;

import java.util.Scanner;

public class Random {

	public static void main(String[] args) {
			//수동 개수 입력할 변수
			int cnt = 0;
			
			System.out.println("수동으로 선택하셨습니다.몇 개의 수를 입력하시겠습니까?(최대 6개)");
			Scanner sc1 = new Scanner(System.in);
			String stic = sc1.nextLine();
				
			switch(stic) {
				case "1" : cnt = 1; break;
				case "2" : cnt = 2; break;
				case "3" : cnt = 3; break;
				case "4" : cnt = 4; break;
				case "5" : cnt = 5; break;
				case "6" : cnt = 6; break;
				default: System.out.println("숫자만 입력해주세요");return;
			}
				
			System.out.print("수동으로 입력할 숫자를 차례대로 한개씩 입력해주세요:");
			int[] arr = new int[6] ;
			for(int i=0; i<cnt; i++) {
				System.out.println((i+1)+"번째 숫자:");
				arr[i] = sc1.nextInt();
			}
			
			//나머지 자동숫자 넣기
			for(int i=0; i<arr.length;i++){
				if(arr[i] == 0) {
					arr[i] = (int)(Math.random()*45+1);
				}
			}
			
			//중복 번호 제거
			for(int i=0; i<arr.length;i++){
				for(int j=0; j<i; j++){
					if(arr[i]==arr[j]) {
						arr[j] = (int)(Math.random()*45+1);
						i--;
						break;
					}
				}
			}
			
			//번호 출력
			for(int i=0; i<arr.length;i++){
				System.out.println((i+1)+"번째 숫자: "+arr[i]);
			}
			
		}//main

}//class
