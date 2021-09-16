package thread;

public class MyContainer implements Runnable{
	private int cnt;
	
	@Override
	public void run() {
		increaseCnt();
	}

	public MyContainer() {
		// TODO Auto-generated constructor stub
	}

	public synchronized void increaseCnt() {
//		synchronized(this) {
			int num = 10;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.cnt++;			
//		}
		
		// cnt = this.cnt;
		// cnt = cnt + 1;
		// this.cnt = cnt;
		
		
//		int cnt = this.cnt;
//		System.out.println("1=======================");
//		System.out.println("this.cnt : " + this.cnt);
//		System.out.println("cnt : " + cnt);
//		cnt = cnt + 1;
//		
//		System.out.println("2=======================");
//		System.out.println("this.cnt : " + this.cnt);
//		System.out.println("cnt : " + cnt);
//		
//		this.cnt = cnt;
		
	}
	public synchronized int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	
}
