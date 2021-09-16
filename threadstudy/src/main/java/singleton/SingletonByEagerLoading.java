package singleton;

public class SingletonByEagerLoading {
	public static SingletonByEagerLoading instance = new SingletonByEagerLoading();
	static {
		System.out.println("static block");
		System.out.println(instance);
	}
	private SingletonByEagerLoading() {
	}
	public static void m1() {
		System.out.println("m1 called");
	}
}
