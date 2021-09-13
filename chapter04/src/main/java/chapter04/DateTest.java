package chapter04;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);
		
		printDate01(now);
		printDate02(now);
	}

	private static void printDate01(Date d) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sdf.format(d);
		System.out.println(date);
	}
	
	private static void printDate02(Date d) {
		// 년도(+1900)
		int year = d.getYear() + 1900;

		// 월(0~11, +1)
		int month = d.getMonth() + 1;
		
		int date = d.getDate();
		int hours = d.getHours();
		int minutes = d.getMinutes();
		int seconds = d.getSeconds();
		
		System.out.println(year + ", " + month + ", " + date + " " 
						+ hours + ":" + minutes + ":" + seconds);
	}

}
