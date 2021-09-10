package chapter04;

public class ObjectTest03 {
	public static void main(String[] args) {
		String s1 = new String("hello");
		String s2 = new String("hello");
		test(s1, s2);
		
	
		String s3 = "hello";
		String s4 = "hello";
		test(s3, s4);
	}
	static void test(String s1, String s2) {
		System.out.println("=================================");
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		System.out.println(s1.hashCode() + " : " + s2.hashCode());
		System.out.println(System.identityHashCode(s1) + " : " + System.identityHashCode(s2));		
	}
}