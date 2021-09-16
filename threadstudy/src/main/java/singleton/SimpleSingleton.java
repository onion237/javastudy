package singleton;

public class SimpleSingleton{
	private static SimpleSingleton instance;
	private SimpleSingleton() {}
	
	public static SimpleSingleton getInstance() {
			if(instance == null)
				synchronized (SimpleSingleton.class) {
					if(instance == null)
						instance = new SimpleSingleton();
				}
			
			return instance;			
	}

}
