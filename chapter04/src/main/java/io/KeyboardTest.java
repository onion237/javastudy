package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

public class KeyboardTest {
	public static void main(String[] args) {
		//1. 기반 스트림(표준입력, stdin, System.in)
		//2. 보조 스트림1(byte|byte|byte -> char) : bytes to character
		//3. 보조 스트림2(char1|char2|char3|char4|\n -> "char1char2char3char4") : characters to string
		//부가기능 decorating
		
		BufferedReader br = null;
		try {
			Reader ir = new InputStreamReader(System.in, "utf-8");
			br = new BufferedReader(ir);
			String line = null;
			
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
			
			System.out.println("end");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(br != null)
					br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("dasdasdads");
		
	}
}