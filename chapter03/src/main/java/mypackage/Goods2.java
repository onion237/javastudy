package mypackage;

public class Goods2 {
	public String name; //모든 클래스에서 접근 가능
	protected int price; //상속관계에 있는 클래스 or 같은 패키지에 있는 클래스에서 접근 가능
	int countStock; // 같은 패키지에 있는 클래스에서 접근 가능
	private int countSold; // 해당 클래스 내부에서만 접근 가능
	
	void m() {
		countSold = 100;
	}
}
