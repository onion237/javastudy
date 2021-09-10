package exception;

import java.io.IOException;


public class MyClass {
	
	public void danger() throws IOException, MyException {
		System.out.println("do something1...");
		System.out.println("do something2...");
		
		if (10 - 10 == 0)
			throw new IOException();

		System.out.println("do something3...");
		System.out.println("do something4...");

		throw new MyException();
	}

	public void dnager2() {

	}
}
