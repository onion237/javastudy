package chapter04;

public class ObjectTest02 {
	public static void main(String[] args) {
		Point p1 = new Point(10, 20);
		Point p2 = new Point(10, 20);
		Point p3 = p2;
		
		//동일성
		System.out.println(p1 == p2); // false
		System.out.println(p3 == p2); // true
		
		//동질성
		System.out.println(p1.equals(p2)); // false;
		System.out.println(p1.equals(p3)); // false;
		System.out.println(p2.equals(p3)); // true;
		
	}
}
