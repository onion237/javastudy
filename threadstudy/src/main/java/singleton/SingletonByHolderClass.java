package singleton;

public class SingletonByHolderClass {
	static {
		System.out.println("static block of outer class");
	}
	private SingletonByHolderClass() {
	}
	public static void m1() {
		System.out.println("m1 called");
	}
	static class Holder{
		static {
			System.out.println("static block of inner class");
		}
		public static SingletonByHolderClass instance = new SingletonByHolderClass();		
	}
}
