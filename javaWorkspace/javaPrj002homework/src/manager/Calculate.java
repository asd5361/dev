package manager;

public class Calculate {
	
	int num;
	int size;
	int price;
	int amount;
	int sum;
	
	public int menuSum(String chosemenu,String chosesize, int amount) {
		MenuList menuList = new MenuList();
		
		//메뉴 분별 (menu 배열 방 숫자)
		num = Integer.parseInt(chosemenu);
		
		//사이즈 분별 (L이면 +500 ,S이면 -500)
		if(chosesize.equals("S")) {
			this.size = -500;
		}else if(chosesize.equals("B")) {
			this.size = +1000;
		}else {
			this.size = 0;
		}
		
		
		//메뉴에 따른 가격 넣기
		Menu menu = menuList.menu[num-1];
		this.price = menu.getPrice();
		
		//결제 계산
		sum =(price+size)*amount;
		
		return sum;
		
	}//menusum
	
}
