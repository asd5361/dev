package manager;

public class MenuList {
	
	Menu menu[] = new Menu[3];


	public MenuList() {
		
		menu[0] = new Menu("아메리카노",3500);
		menu[1] = new Menu("커피라떼",4000);
		menu[2] = new Menu("오레오 파르페",5000);
		
	}
	
	public void printMenuList() {
		for(int i=0;i<menu.length;i++) {
			System.out.println(i+1+". "+menu[i].getName()+" "+menu[i].getPrice()+"원");
		}
	}
	
	
	
	
	
	
	
	
	
}

