package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//			String line = br.readLine();
//			System.out.println("----------------------------------------");
//			System.out.println("A + " + line);
		String str = "한";
		char ch = '한';
		System.out.println(str.getBytes().length);
		System.out.println(ch);
	}
}
