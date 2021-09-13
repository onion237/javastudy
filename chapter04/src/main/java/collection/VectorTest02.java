package collection;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class VectorTest02 {
	public static void main(String[] args) {
		List<String> list = new Vector<>();
		list.add("둘리");
		list.add("또치");
		list.add("도우너");
		
		
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}
		
		//새로운 iterator 객체를 이용해서 순회해야함
		//기존 iterator는 play back x
//		while(it.hasNext()) {
//			String s = it.next();
//			System.out.println(s);
//		}
		
		
		System.out.println("------------remove-------------");
		list.remove("또치");
		list.stream().forEach(System.out::println);
	}
}
