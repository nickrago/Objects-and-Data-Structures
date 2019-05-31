package assignment05;

public class Employee implements Comparable<Employee>{
	private Person person;
	private double salary;
	private Employer employer;
	public Employee(Person person, double salary) {
		super();
		this.person = person;
		this.salary = salary;
	}
	public Person getPerson() {
		return person;
	}
	public double getSalary() {
		return salary;
	}
	public Employer getEmployer() {
		return employer;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public void setEmployer(Employer employer) {
		this.employer = employer;
	}
	
	public double increase(double pct) {
		salary = salary * (1 + (pct/100));
		return salary;
	}
	
	@Override
	public int compareTo(Employee o) {
		return person.compareTo(o.person);
	}
	
	@Override
	public String toString() {
		return (person + String.format(" %s: $%,.2f", employer, salary));
	}
	
}
