package main;
import java.util.Scanner;
import java.util.Arrays;

public class Scan {

	public static void main(String[] args) {
			/*중복해결, 정렬, */
			/*
			* 1. 문자를 잘못 입력 했을 경우
			* 2. yes를 눌럿을 경우
			* 3. no를 눌럿을 경우
			*/

			Scanner sc = new Scanner(System.in);
			
			//자동 
			int auto[] = new int[6];
			
			// 자동 or 수동 묻기
			System.out.println("로또 번호를 자동으로 돌리시겠습니까?(yes/no)");
			String user = sc.nextLine();
			
			//자동과 수동 처리
			if(user.equals("yes")){
				//번호 생성
				for(int i=0; i<6; i++) {
					auto[i] = (int)(Math.random()*45+1);
					//중복 번호 제거
					for(int j=0; j<i; j++){
						if(auto[i]==auto[j]) {
							i--;
							break;
						}
					}
				}
				
				//배열 (로또번호) 오른차순 정렬
				Arrays.sort(auto);
				
				//번호 출력
				for(int i=0;i<auto.length;i++) {
					System.out.print(auto[i]+" . ");
				}
			}else if(user.equals("no")){
				//수동 개수 입력
				System.out.println("수동으로 선택하셨습니다.몇 개의 수를 입력하시겠습니까?(최대 6개)");
				int cnt = sc.nextInt();
					
				System.out.print("수동으로 입력할 숫자를 연속으로 입력해주세요:");
				int[] arr = new int[6] ;
				for(int i=0; i<cnt; i++) {
					arr[i] = sc.nextInt();
					if(arr[i] >45) {
						System.out.println("45보다 큰 숫자가 입력됬습니다. 다시 시작해주세요");
						return;
					}
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
				
				//배열 값(로또번호) 오른차순 정렬
				Arrays.sort(arr);
				
				//번호 출력
				for(int i=0; i<arr.length;i++){
					System.out.print(arr[i]+" . ");
				}
			}else {
				System.out.println("잘못 입력하여 종료됩니다.");
				return;
				}
	}//main
}//class
