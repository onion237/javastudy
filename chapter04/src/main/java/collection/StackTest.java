package collection;

import java.util.Stack;

public class StackTest {
	public static void main(String[] args) {
		Stack<String> s = new Stack<>(); // -> Vector ---> List
		s.push("둘리");
		s.push("또치");
		s.push("도우너");
		
		while(!s.isEmpty()) {
			System.out.println(s.pop());
		}
		
		for(String el : s) {
			System.out.println(el);
		}
	}
}
