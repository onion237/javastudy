package collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest01 {
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		String s1 = new String("도우너");
		String s2 = new String("도우너");
		
		
		set.add("둘리");
		set.add("마이콜");
		set.add("또치");
		set.add(s2);
		
		System.out.println(set.size());
		System.out.println(set.contains(s1));
		set.stream().forEach(System.out::println);
		System.out.println("==================================");		
		set.add("또치");
		System.out.println(set.size());
		set.stream().forEach(System.out::println);
	}
}
