package exception;

public class ExceptionTest {
	public static void main(String[] args) {
		int a = 10;
		int b = 10 - a;
		
		System.out.println("some code1...");
		try {
			System.out.println(a / b);			
		}catch(ArithmeticException e) {
			//1. 사과
			System.out.println("sorry...");
			//2. 로깅
			System.out.println("error info : " + e);
			//3. 정상종료
			return;
		} finally {
			System.out.println("자원정리...");
		}
		System.out.println("some code2...");
	}
}
