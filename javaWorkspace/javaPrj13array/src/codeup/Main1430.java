package codeup;

import java.nio.file.spi.FileSystemProvider;
import java.util.Scanner;

public class Main1430 {

	public static void main(String[] args) {
		/*
		 * 몇개 입력하겟다!
		 * 
		 * 몇개 입력!
		 * 
		 * 몇개 입력하겠다!
		 * 
		 * 몇개 입력
		 * 
		 */
		//스캐너 객체 생성
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		
		//첫번째 입력할 개수 받기
		int fnum = sc.nextInt();
		int[] farr = new int[fnum];
		
		//입력받기
		for(int i=0; i<fnum; i++) {
			farr[i] = sc.nextInt();
		}
		
		//두번쨰 입력할 개수 받기
		int snum = sc.nextInt();
		int[] sarr = new int[snum];
		
		//입력받기
		for(int i=0; i<snum; i++) {
			sarr[i] = sc.nextInt();
		}
		//출력할 배열 
		int[] parr = new int[snum];

		
		for(int i=0;i<sarr.length; i++) {
			for(int j=0; j<farr.length;j++) {
				if(sarr[i] == farr[j]) {
					parr[i]++;
				}
			}
		}
		
		//결과 출력
		for(int i=0; i<parr.length; i++) {
			System.out.print(parr[i]+" ");
		}
		
	}//main

}//class

