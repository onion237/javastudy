package chapter03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import chapter03.Person.Builder;

public class Student extends Person{
	private int studentNo;
	private String grade;
	
	{
		System.out.println("Student instance block");
	}
	public Student() {
		super();
		System.out.println("Student() called");
	}
	
	public Student(Builder builder) {
		super(builder);
		this.studentNo = builder.studentNo;
		this.grade = builder.grade;
	}

	public int getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	static class Builder extends Person.Builder<Builder>{
		private int studentNo;
		private String grade;
		
		public Builder studentNo(int studentNo) {
			this.studentNo = studentNo;
			return this;
		}
		public Builder grade(String grade) {
			this.grade = grade;
			return this;
		}
		public Student build() {
			return new Student(this); 
		}
		
		
		@Override
		public Student.Builder self() {
			// TODO Auto-generated method stub
			return this;
		}
	}
}
