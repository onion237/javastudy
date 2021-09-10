package chapter04;

import java.util.Arrays;

public class ObjectTest01 {
	public static void main(String[] args) {
		String s1 = "hello";
		String s2 = new String("hello");
		System.out.println(s1 == s2);
		Point p = new Point(10,10);
		
		System.out.println(Integer.toHexString(p.hashCode())); // address or reference가 hash함수의 input
		System.out.println(p);
		System.out.println(p.toString());
		
		Class clazz = p.getClass();
		System.out.println(clazz.getModifiers());
		System.out.println(Arrays.asList(clazz.getMethods()[0].getName()));
	}
}
