package assignment04.assignment04;

public class Student implements Comparable<Student>{
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
		return id + " " + this.name;
	}

  public int compareTo(Student stu){
    return (id - stu.id);
  }

	@Override
	public int hashCode() {
		return id;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) return id == ((Student)obj).id;
		return false;
	}
}
