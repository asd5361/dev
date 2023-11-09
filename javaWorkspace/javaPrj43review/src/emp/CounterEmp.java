package emp;

import java.util.*;
import menu.Menu;

public class CounterEmp {

	private final Scanner sc = new Scanner(System.in);
	private List menuList = new ArrayList();

	private void showMenu() {
		
		// 메뉴판 준비
		menuList.add(new Menu("아메리카노",3000));
		menuList.add(new Menu("카페라떼",4000));
		menuList.add(new Menu("청포도에이드",5000));
		menuList.add(new Menu("달고나라떼",6000));
		menuList.add(new Menu("밀크쉐이크",7000));
		
		// 메뉴판 출력
		for(int i=0; i < menuList.size(); i++) {
			Menu x = (Menu)menuList.get(i);
			System.out.println((i+1)+":"+x.getName()+ " ("+ x.getPrice()+"원)");
		}
		System.out.println("===============================================");
		
	}
	//손님 받음
	public void work() {
		//메뉴 보여주기
		showMenu();
		
		//메뉴 입력받기
		System.out.print("\n원하시는 메뉴 번호를 입력하세요 :");
		int menuNum= ScanUserInput();
		
		//선택한 메뉴 확인시켜주고, 금액 더하기
		printMenu(menuNum);
		
		//갯수 입력 받기
		System.out.print("\n수량을 입력하세요 :");
		int menuCnt= ScanUserInput();
		
		//결제 (금액)
		int totalPrice =0;
		int price = getMenuprice(menuNum);
		
		totalPrice += price*menuCnt;
		System.out.println("\n결제 금액은 "+totalPrice+"원 입니다.");
		
		
	}
	
	private int getMenuprice(int n) {
		Menu result = (Menu)menuList.get(n-1);
		int price =result.getPrice();
		return price;
	}
	
	public void printMenu(int num) {
		Menu result = (Menu)menuList.get(num-1); //타입 변환
		System.out.println("\n주문하신 메뉴는 "+result.getName()+"입니다.");
		System.out.println("메뉴 가격은 "+result.getPrice()+"입니다.");
		
		
	}
	public int ScanUserInput() {
		String numSrt = sc.nextLine();
		int num = Integer.parseInt(numSrt);
		return num;
		
	}
	
	
	
	 
}
