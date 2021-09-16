package io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class FileReaderTest {
	public static void main(String[] args) {
		try(Reader reader = new FileReader("test.txt");
				Writer writer = new FileWriter("test-copy.txt")) {
			int data;
			int count = 0;
			while( (data = reader.read()) != -1) {
				writer.write(data);
				System.out.print((char)data);
				count++;
			}
			System.out.println();
			System.out.println(count);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
