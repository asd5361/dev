package main;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		//소수 판별 코드업1274
		
				//정수 입력 받기
				Scanner sc = new Scanner(System.in); //스캐너 객체 준비
				int num = sc.nextInt();
				
				//소수인지 판단하기
				// 약수가 2개 (1과 자기 자신)
				// ==> 1, 자신 빼고 다른 수로 나누어 지면 안된다.
				
				// 2 ~ num-1 중에서 num이랑 나눴을 때, 나누어 떨어지는게 있는지?
				
				boolean isPrime = true;
				for(int i=2; i< num/2; i++) {
					if(num % i == 0) {
						isPrime = false;
					}
				}
				//결과출력_삼항연산자
				String srt = isPrime ? "prime": "not prime";
				if (num ==1) {
					System.out.println("not prime");
				}else {
					System.out.println(srt);
				}

	}

}
