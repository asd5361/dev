package phon;

public class Phon {

	int price;
	String datetype;
	String phontype;
	String produce;
	
	public void CallMesage() {
		System.out.println("사용하는 폰은 기본형 (2G)입니다.");
	}
	
	public void SMS() {
		System.out.println("카톡을 사용해주세요.");
	}

	@Override
	public String toString() {
		return " [price=" + price + ", datetype=" + datetype + ", phontype=" + phontype + ", produce=" + produce
				+ "]";
	}
	
	
}
