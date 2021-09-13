package chapter04;

import java.time.DayOfWeek;
import java.time.Month;
import java.util.Calendar;

public class CalendarTest {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2021);
		cal.set(Calendar.MONTH, 11);//12
		cal.set(Calendar.DATE, 25);
		
		printDate(cal);
		
		cal.set(2021, 8, 13);
		cal.add(Calendar.DATE, 100);
		printDate(cal);
	}

	private static void printDate(Calendar cal) {
		final String[] DAYS = {"일","월","화","수","목","금","토"};
		int year = cal.get(Calendar.YEAR);
		
		int month = cal.get(Calendar.MONTH); // 0 ~ 11
		int date = cal.get(Calendar.DATE);
		int day = cal.get(Calendar.DAY_OF_WEEK); // 1~7
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		
//		DayOfWeek dayOfWeek = DayOfWeek.of(day - 1);
//		Month m = Month.of(month);
//		System.out.println(day);
//		System.out.println(dayOfWeek);
//		System.out.println(DAYS[day - 1]);
		
		
		System.out.println(year + ", " + (month + 1) + ", " + date + " " 
						+ DAYS[day - 1] + " "+ hour + ":" + minute + ":" + second);
		
	}
}
