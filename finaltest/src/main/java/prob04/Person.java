package prob04;

public class Person {
	private static int numberOfPerson; // 전체 인구수
	private int age;
	private String name;
	
	public Person() {
		this(12, "");
	}
	public Person(String name) {
		this(12, name);
	}
	public Person(int age, String name) {
		this.age = age;
		this.name = name;
		synchronized (Person.class) {
			numberOfPerson++;			
		}
	}
	
	synchronized public static int getPopulation() {
		return numberOfPerson;
	}
	public void selfIntroduce() {
		System.out.println("내 이름은 " + name +"이며, 나이는 " + age + "살 입니다.");
	}
	
}
