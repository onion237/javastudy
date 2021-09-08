package chapter03;

public class GoodsApp {
	public static void main(String[] args) {
		Goods goods = new Goods();
		goods.setName("Nikon");
		goods.setPrice(3000);
		goods.setCountStock(20);
		goods.setCountSold(10);
		
		goods.showInfo();
		System.out.println(goods.calcDiscountPrice(50));
		
		Goods goods2 = new Goods();
		Goods goods3 = new Goods();
		
		System.out.println(Goods.countOfGoods);
	}
}
