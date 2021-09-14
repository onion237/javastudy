package prob5;

public class MyStack<E> {
	private final int DEFAULT_SIZE = 8;
	private int top = -1;
	private E[] arr;
	
	public MyStack() {
		super();
		arr = (E[])new Object[DEFAULT_SIZE];
	}
	
	public MyStack(int i) {
		arr = (E[])new Object[i];
	}
	
	public void push(E item) {
		if(isFull()) transfer();
		arr[++top] = item;
	}
	
	public void transfer() {
		E[] nArr = (E[])new Object[arr.length * 2];
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

	public E pop() throws MyStackException {
		if(isEmpty()) {
			throw new MyStackException("stack is empty");
		}
		
		E item = arr[top--];
		return item;
	}
}