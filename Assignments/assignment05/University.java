package assignment05;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class University implements Comparable<University>{
	private String name;
	private List<Person> faculty;
	private List<Person> staff;
	private List<Person> students;
	public University(String name) {
		super();
		this.name = name;
		List<Person> faculty = new ArrayList<>();
		List<Person> staff = new ArrayList<>();
		List<Person> students = new ArrayList<>();
	}
	public String getName() {
		return name;
	}
	public boolean addFaculty(Person p) {
		return faculty.add(p);
	}
	public boolean removeFaculty(Person p) {
		return faculty.remove(p);
	}
	public boolean addStaff(Person p) {
		return staff.add(p);
	}
	public boolean removeStaff(Person p) {
		return staff.remove(p);
	}
	public boolean addStudent(Person p) {
		return students.add(p);
	}
	public void doAddStudent(Person p) {
		students.add(p);
	}
	public boolean removeStudent(Person p) {
		return students.remove(p);
	}
	public int compareTo(University arg) {		
		return (students.size() - arg.students.size());
	}
	public Comparator<University> makeComparator(){
		Comparator<University> nameComp = (u1, u2) -> u1.getName().compareToIgnoreCase(u2.getName());
		Comparator<University> natural = Comparator.naturalOrder();
		Comparator<University> descending = natural.reversed();
		return descending.thenComparing(nameComp);
	}
	
	
}
