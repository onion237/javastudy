package chapter03;

public class StaticMethod {
	int n;
	static int m;
	
	void f1() {
		System.out.println(n);
	}
	
	void f2() {
		System.out.println(StaticMethod.m);
		System.out.println(m);
	}
	
	void f3() {
		f2();
	}
	
	static void s1() {
		// 오류 : static mothod에서는 인스턴스 변수에 접근 x
//		System.out.println(n);
	}
}
