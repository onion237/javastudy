package chapter03;

public class Person {
	private String name;
	{
		System.out.println("Person instance block");
	}
	public Person() {
		System.out.println("Person() called");
	}	
	public Person(String name) {
		this.name = name;
	}

	public Person(Builder builder) {
		this.name = builder.name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	static abstract class Builder<T>{
		private String name;
		
		public T name(String name) {
			this.name = name;
			return self();
		}
		public abstract T self();
	}
}
