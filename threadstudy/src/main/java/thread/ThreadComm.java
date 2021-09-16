package thread;

import java.util.concurrent.TimeUnit;

public class ThreadComm {
	private static volatile boolean stop = false;
	private static volatile int runningThreadCount = 50;

	public static void main(String[] args) throws InterruptedException {
		Thread backgroundThread = new Thread(() -> {
			while (!stop) {
				//
				System.out.println("asdasd");
			}
			System.out.println("end");
		});
		backgroundThread.start();
		TimeUnit.SECONDS.sleep(1);
		stop = true;
		TimeUnit.SECONDS.sleep(10);
		System.out.println("last - running thread count = " + runningThreadCount);
	}
}
