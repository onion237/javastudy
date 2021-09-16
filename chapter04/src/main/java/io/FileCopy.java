package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy {
	public static void main(String[] args) {
		System.out.println(System.getProperty("file.encoding"));
		try(InputStream is = new FileInputStream("캡처.PNG"); OutputStream os = new FileOutputStream("복사.PNG")) {
			int r;
			while((r = is.read()) != -1) {
				os.write(r);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
