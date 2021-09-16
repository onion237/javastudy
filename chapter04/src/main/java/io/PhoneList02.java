package io;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PhoneList02 {
	public static void main(String[] args) {
		// 1. 기반 스트림(표준입력, stdin, System.in)
		// 2. 보조 스트림1(byte|byte|byte -> char) : bytes to character
		// 3. 보조 스트림2(char1|char2|char3|char4|\n -> "char1char2char3char4") : characters
		// to string
		// 부가기능 decorating
		Scanner sc = null;
		try {
			File file = new File("phone.txt");

			if (!file.exists()) {
				System.out.println("file not found");
				return;
			}

			System.out.println("============file info=============");
			System.out.println(file.getAbsolutePath());
			System.out.println(file.getParent());
			System.out.println(file.length() + "bytes");
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(file.lastModified())));

			System.out.println("============phone number=============");
			sc = new Scanner(file);
			String line = null;

			// Tokenizing
			while (sc.hasNext()) {
				System.out.println(sc.next() + " : " + sc.next() + "-" + sc.next() + "-" + sc.next());
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sc != null)
				sc.close();
		}
		System.out.println("dasdasdads");

	}
}
