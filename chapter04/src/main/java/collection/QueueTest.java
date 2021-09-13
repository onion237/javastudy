package collection;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
	public static void main(String[] args) {
		Queue<String> q = new LinkedList<>();
		
		q.offer("둘리");
		q.offer("또치");
		q.offer("도우너");
		
		while(!q.isEmpty()) {
			System.out.println(q.poll());
		}
	}
}
