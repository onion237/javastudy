package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.StringTokenizer;

public class PhoneList01 {
	public static void main(String[] args) {
		//1. 기반 스트림(표준입력, stdin, System.in)
		//2. 보조 스트림1(byte|byte|byte -> char) : bytes to character
		//3. 보조 스트림2(char1|char2|char3|char4|\n -> "char1char2char3char4") : characters to string
		//부가기능 decorating
		BufferedReader br = null;
		try {
			File file = new File("phone.txt");
			
			if(!file.exists()) {
				System.out.println("file not found");
				return;
			}
			
			System.out.println("============file info=============");
			System.out.println(file.getAbsolutePath());
			System.out.println(file.getParent());
			System.out.println(file.length() + "bytes");
			System.out.println(file.lastModified());
			
			System.out.println("============phone number=============");
			Reader ir = new InputStreamReader(new FileInputStream(file), "utf-8");
			br = new BufferedReader(ir);
			String line = null;
			
			
			//Tokenizing
			while((line = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, "\t ");
				
				int index = 0;
				while(st.hasMoreElements()) {
					String token = st.nextToken();
					if(index == 0)
						System.out.print(token + ":");
					else
						System.out.print(token + (index != 3? "-" : ""));
					
					index++;
				}
				
				System.out.println();
			}
			
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
