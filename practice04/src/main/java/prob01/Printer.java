package prob01;

import java.util.Arrays;

public class Printer {

//	public void println(String string) {
//		System.out.println(string);
//	}
//
//	public void println(int i) {
//		// TODO Auto-generated method stub
//		System.out.println(i);
//	}
//
//	public void println(boolean b) {
//		// TODO Auto-generated method stub
//		System.out.println(b);
//	}
//
//	public void println(double d) {
//		// TODO Auto-generated method stub
//		System.out.println(d);
//	}
//	public void println(Object o) {
//		System.out.println(o);
//	}

	public <T> void println(T t) {
		System.out.println(t);
	}
	
	public <T> void println(T... t) {
		System.out.println(Arrays.toString(t));
	}

	public int sum(int... nums) {
		// TODO Auto-generated method stub
		int sum = 0;
		for(int num : nums) sum += num;
		return sum;
	}
}
