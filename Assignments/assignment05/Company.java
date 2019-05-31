package assignment05;

import java.util.ArrayList;
import java.util.List;

public class Company implements Employer{
	private String companyName;
	private List<Employee> employees = new ArrayList<>();
	public Company(String companyName) {
		super();
		this.companyName = companyName;
	}
	
	@Override
	public String toString() {
		return ("Company: " + companyName);
	}
	
	@Override 
	public List<Employee> listEmployees(){
		return employees;
	}
	
	public void addEmp(Employee e) {
		e.setEmployer(this);
		employees.add(e);
	}
	
	public void addPerson(Person p, double salary) {
		addEmp(new Employee(p, salary));
	}
}
