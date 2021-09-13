package chapter04;

public class WrapperClassTest02 {
	public static void main(String[] args) {
		String s1 = "123456";
		int i = Integer.parseInt(s1);
		s1 = String.valueOf(i + 7);
		System.out.println(i);
		System.out.println(s1);
		
		int n = Character.getNumericValue('b');
		System.out.println(n);
		
		String s2 = Integer.toBinaryString(15);
		System.out.println(s2);
		
		String s16 = Integer.toHexString(15);
		System.out.println(s16);
		
	}
}
