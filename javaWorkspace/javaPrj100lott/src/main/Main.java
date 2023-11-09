package main;

public class Main {

	public static void main(String[] args) {
		
		
		System.out.println("로또 번호를 불러드리겠습니다.");
		
		int auto[] = new int[6];
		
		//번호 생성
		for(int i=0; i<6; i++) {
			auto[i] = (int)(Math.random()*45+1);
			//중복 번호 제거
			for(int j=0; j<i;j++) {
				if(auto[i]==auto[j]) {
					i--;
					break;
				}
			}
				
		}
		//번호 출력
		for(int i=0; i<auto.length;i++) {
			System.out.println((i+1)+"번째 자리는 "+ auto[i]+"입니다.");
		}
	}

}
