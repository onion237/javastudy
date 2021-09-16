package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderTest {
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new FileReader("./src/main/java/io/BufferedReaderTest.java"))) {			
			String str;
			int idx = 0;
			while((str = br.readLine()) != null) {
				System.out.println(++idx + " : " + str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
