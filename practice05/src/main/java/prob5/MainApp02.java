package prob5;

public class MainApp02 {
	public static void main(String[] args) {
		try {
			MyStack<Integer> stack = new MyStack(3);
			stack.push(1);
			stack.push(2);
			stack.push(3);
			stack.push(4);
			stack.push(5);

			while (stack.isEmpty() == false) {
				Integer n = stack.pop();
				System.out.println(n);
			}

			System.out.println("======================================");

			stack = new MyStack(3);
			stack.push(1);

			System.out.println(stack.pop());
			System.out.println(stack.pop());

		} catch (MyStackException ex) {
			System.out.println(ex);
		}

	}
}
