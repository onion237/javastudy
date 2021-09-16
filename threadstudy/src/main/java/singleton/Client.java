package singleton;

public class Client implements Runnable{

	@Override
	public void run() {
		SimpleSingleton instance = SimpleSingleton.getInstance();
		System.out.println(instance);
	}

}
