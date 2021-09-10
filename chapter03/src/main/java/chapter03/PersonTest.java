package chapter03;

public class PersonTest {
	public static void main(String[] args) {
		Student s = new Student
				.Builder().
				studentNo(0).
				name(null).
				grade("A")
				.build();
		System.out.println(s instanceof Object);
	}
}
