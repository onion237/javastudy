package chapter03;

import mypackage.Goods2;

public class GoodsApp2 {
	public static void main(String[] args) {
		Goods2 goods = new Goods2();
		goods.name = "camera"; // public : 모든 클래스
//		goods.price = 2000; // protected : 같은 패키지 클래스 or 자식 클래스
//		goods.countStock = 100; // default : 같은 패키지 클래스
//		goods.countSold = 10; // private : 해당 클래스 내부에서만 접근 가능
	}
}
