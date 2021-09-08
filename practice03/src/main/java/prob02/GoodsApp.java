package prob02;

import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];
		String[] goodsInfo;
		// 상품 입력
		for(int i = 0; i < COUNT_GOODS; i++) {
			goods[i] = new Goods();
			goodsInfo = scanner.nextLine().split(" ");
			goods[i].setName(goodsInfo[0]);
			goods[i].setPrice(Integer.parseInt(goodsInfo[1]));
			goods[i].setCountStock(Integer.parseInt(goodsInfo[2]));
		}
		// 상품 출
		for(Goods g : goods) {
			System.out.println(g.getName() + "(가격:" + g.getPrice() + "원)이 " + g.getCountStock() +"개 입고 되었습니다.");
		}
		// 자원정리
		scanner.close();
	}
}
