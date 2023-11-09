package loop;

public class Practice {

	public static void main(String[] args) {
		
		//반복문 연습
		
//		int i = 0;		
//		while(i<5) {	
//			System.out.print("*");
//			i++;		
//			
//			if(i==5) {
//				System.out.println("\n end");
//			}
//		}
//		for(int i = 1; i<5; i++) {
//			for(int j = 0; j<i; j++) {
//				System.out.print("*");
//			}
//			System.out.println(" ");
//		}//삼각형 별 ( *을 줄 수만큼 찍는다)
		
//		int num=6;
//		for(int i=1; i<num; i++) {
//			for(int j=num-1; j>0; j--) {
//				if(i<j) {
//					System.out.print(" ");
//				}else {
//					System.out.print("*");
//				}
//			}
//			System.out.println("");
//		}//줄 수만큼만 찍는다. (줄수-1 수로 반복문 시작, 줄 수와 동일한 수 이후부터 * 찍음)
		int num=5;
		for(int i=0; i<num; i++){
			for(int j=0; j<(num-1)-i; j++) {
				System.out.print(" ");
			}
			for(int j=0; j<2*i+1;j++){
				System.out.print("*");
			}
			System.out.println("");
		}//줄수 -1 만큼 여백 찍기, 별은 1,3,5,7,9 홀수 찍기
	}
}
