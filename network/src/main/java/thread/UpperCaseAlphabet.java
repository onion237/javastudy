package thread;

public class UpperCaseAlphabet {

	public void print() {
		for(char c = 'A'; c <= 'Z'; c++) {
			System.out.print(c);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
