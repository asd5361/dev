package practice;

public class ArrayTest {

	
	/*
	 *  배열
	 *  type[] name = new type[size];
	 *  변수타입[] 변수이름 = new 변수타입[배열사이즈];
	 *  int[] arr = new int[3];
	 *  
 	 *  타입이 같은 변수를 여러개를 한번에 만들어 줌
	 *  주의사항 : 처음부터 사이즈를 지정해야함
	 * 
	 * 다차원 배열
	 * int[][] arr = new int[3][3];
	 * 
	 */
	
	public void test() {
		//배열변수 선운
		int [] x;
		
		//배열 생성 후 배열변수에 할당
		x  = new int[3];
		x[0] = 10;				//0번 인덱스 칸에 값을 할당
		
		System.out.println(x[0]);//0번 인덱스 칸의 값을 꺼내오고, 출력
		
	}
}
