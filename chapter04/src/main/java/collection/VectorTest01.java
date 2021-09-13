package collection;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class VectorTest01 {
	public static void main(String[] args) {
		Vector<String> v = new Vector<>();
		
		v.addElement("둘리");
		v.addElement("또치");
		v.addElement("도우너");
		
		//순회
		for (int i = 0; i < v.size(); i++) {
			String s = v.elementAt(i);
			System.out.println(s);
		}
		
		//순회2
		Enumeration<String> e = v.elements();
		while(e.hasMoreElements()) {
			String s = e.nextElement();
			System.out.println(s);
		}
		
		//순회3
		Iterator<String> it = v.iterator();
		while(it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}
		
		//순회4
		v.removeElementAt(2);
		for (String s : v) {
			System.out.println(s);
		}
	}
}
