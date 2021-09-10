package prob5;

public class MyStack {
	private final int DEFAULT_SIZE = 8;
	private int top = -1;
	private String[] arr;
	
	public MyStack() {
		super();
		arr = new String[DEFAULT_SIZE];
	}
	
	public MyStack(int i) {
		arr = new String[i];
	}
	
	public void push(String item) {
		if(isFull()) transfer();
		arr[++top] = item;
	}
	
	public void transfer() {
		String[] nArr = new String[arr.length * 2];
		for(int i = 0; i < arr.length; i++) {
			nArr[i] = arr[i];
		}
		top = arr.length - 1;
		arr = nArr;
	}
	
	private boolean isFull() {
		return top >= arr.length - 1;
	}
	
	public boolean isEmpty() {
		return top < 0;
	}

	public String pop() throws MyStackException {
		if(isEmpty()) {
			throw new MyStackException("stack is empty");
		}
		
		String item = arr[top--];
		return item;
	}
}