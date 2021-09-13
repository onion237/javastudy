package chapter04;

import java.util.Arrays;

public class StringTest03 {
	public static void main(String[] args) {
//		String s1 = "Hello " + "World " + "Java " + 1.8;
		String s1 = new StringBuffer("Hello ")
				.append("World")
				.append(" Java")
				.append(1.8)
				.toString();
		
		System.out.println(s1);
		
		String s2 = "";
		for(int i = 0; i < 100000; i++) {
//			s2 = s2 + i;
//			s2 = new StringBuffer(s2).append(i).toString(); //identical to the line above
		}
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < 100000; i++) {
			sb.append(i);
		}
		System.out.println(sb.length());
		
		//String method들
		String s4 = "aBcABCabcAbc";
		System.out.println(s4.length());
		System.out.println(s4.charAt(0));
		System.out.println(s4.indexOf("abc", 7));
		System.out.println(s4.substring(3,5));

		String s5 = "    ab    cd    ";
		String s6 = "efg,hi,jkl,mno,pqr";
		
		String s7 = s2.concat(s4);
		
		System.out.println(s7);
		System.out.println(s5.trim());
		Arrays.stream(s6.split(",")).forEach(System.out::println);
		System.out.println("-------------------------------");
		Arrays.stream(s6.split(" ")).forEach(System.out::println);
		System.out.println("-------------------------------");
	}
}
