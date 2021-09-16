package thread;

public class ThreadEx01 {
	public static void main(String[] args) {
		Thread digitThread = new DigitThread();
		Thread alphabetThread = new AlphabetThread();
		Thread upperCaseAlphabetThread = new Thread(new UpperCaseAlphabetRunnableImpl());
		
		digitThread.start();
		alphabetThread.start();
		upperCaseAlphabetThread.start();
		try {
			digitThread.join();
			alphabetThread.join();
			upperCaseAlphabetThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("all threads terminated");
	}
}