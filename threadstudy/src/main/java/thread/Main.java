package thread;


public class Main {
	public static void main(String[] args) {
		MyContainer mc = new MyContainer();
		for(int i = 0; i < 10; i++) {
			new Thread(mc).start();
		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("===========result===========");
		
		System.out.println(mc.getCnt());
	}
}
