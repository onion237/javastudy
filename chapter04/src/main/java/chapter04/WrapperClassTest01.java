package chapter04;

public class WrapperClassTest01 {
	public static void main(String[] args) {
		Integer i1 = 939484343;
		Integer i2 = 939484343;
		Integer i3 = new Integer(3);
		Integer i4 = new Integer(3);
		System.out.println(i1 == i2); // literal pool을 활용하지 않는 값 범위도 존재함, 동등성 비교에 주의할 것
		System.out.println(i1 == i3);
		System.out.println(i4 == i3);
		
		Character c = new Character('c');
		Boolean b = new Boolean(true);
		
		//auto boxing
		Integer num = 10;
		num.intValue();
		//auto unboxing
		int num2 = num;
	}
}
