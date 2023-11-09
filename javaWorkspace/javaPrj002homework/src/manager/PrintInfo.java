package manager;

public class PrintInfo {
	public void printStart() {
		System.out.println("\r\n"
				+ "\r\n"
				+ "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n"
				+ "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n"
				+ "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n"
				+ "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n"
				+ "@@@@@@@@@@@@@@@!   ;@@@@@@@@@@\r\n"
				+ "@@@@@@@@@@:::!*     @@@@@@@@@@\r\n"
				+ "@@@@@@@@:::::#       @@@@@@@@@\r\n"
				+ "@@@@@@@:$@:@:@       @@@@@@@@@\r\n"
				+ "@@@@@@@@-#@@;@       @#@@@@@@@\r\n"
				+ "@@@@@@@; @-,@        @  @@@@@@\r\n"
				+ "@@@@@@@              @   ,@@@@\r\n"
				+ "@@@@@@@              @     @@@\r\n"
				+ "@@@@@@@   @@         @      @@\r\n"
				+ "@@@@@@@;  -:..       =      .@\r\n"
				+ "@@@@@@@;     @      @        @\r\n"
				+ "@@@@@@@!      @~    ~        @\r\n"
				+ "@ .@@@@; =@@@  =@@@-         @\r\n"
				+ "@  @@@@  @  @                @\r\n"
				+ "@   =@-  @  @                @\r\n"
				+ "@@       @  @               .@\r\n"
				+ "@@$      #  @               #@\r\n"
				+ "@@@@    @  !,   @@@@@@@@    @@\r\n"
				+ "@@@@@@@@@  @.   @@@@@@@@    @@\r\n"
				+ "@@@@@@@@  =@,   @@@@@@@@   *@@\r\n"
				+ "@@@@@@@  .@@=  ~@@@@@@@@   @@@\r\n"
				+ "@@@-    =@@@@. @@@@@@@@@: !@@@\r\n"
				+ "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n"
				+ "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n"
				+ "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n"
				+ "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n"
				+ "");
	}
	
	public void printst() {
		System.out.println("메뉴를 확인하시고 주문하실 음료를 선택해주세요 \n ");
	}
	
	public void printmenu() {
		MenuList menuList = new MenuList();
		menuList.printMenuList();
		System.out.print("\n선택한 음료 번호: ");
	}
	
	public void printsize() {
		System.out.println("\n선택하신 음료의 크기를 선택해주세요(B/L/S):");
		System.out.print(" 사이즈 : ");
	}
	
	public void printamount() {
		System.out.println("\n선택하신 음료의 수량을 선택해주세요:");
		System.out.print(" 수량 : ");
	}
	
	public void printSum(int sum) {
		System.out.println("\n선택하신 메뉴의 총 금액은 "+ sum+"원 입니다.");
	}
	public void printCash() {
		System.out.println("\n결제방법을 선택해주세요");
		System.out.println(" 1. 신용카드 \n 2. 현금");
		System.out.println(" 신용카드는 부과세 10%를 추가합니다.");
		System.out.print("결제 방법 번호: ");
	}
	
	public void printlistment(int sum, int cash) {
		String a = "현금";
		if(cash == 1 ) {
			a = "신용카드";
			double card= sum * 1.1;
			sum = (int)card;
		}
		System.out.println(a +"을(를) 선택하셨습니다 .");
		System.out.println("\n 결제 방법은 "+a+"이며, 결제하실 금액은 "+sum+"원 입니다.");
		System.out.println(" 주문이 완료되었습니다. ^______^");
	}

	private int sum(double d) {
		// TODO Auto-generated method stub
		return 0;
	}
}
