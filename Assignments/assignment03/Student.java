package assignment03;

public class Student{
	private int id;
	private String name;

	public Student(int i, String n){
		this.id = i;
		this.name = n;
	}

	public int getId(){
		return this.id;
	}

	public String getName(){
		return this.name;
	}

	public String toString(){
		return this.name;
	}
}
