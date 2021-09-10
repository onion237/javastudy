package chapter04;

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
	}
}
