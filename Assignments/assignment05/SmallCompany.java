package assignment05;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SmallCompany implements Employer{
	private String companyName;
	private List<Employee> employees = new LinkedList<>();
	public SmallCompany(String companyName) {
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
		int k = Collections.binarySearch(employees, e);
		if(k < 0) employees.add(-k-1,e);
	}
	
	public void addPerson(Person p, double salary) {
		addEmp(new Employee(p, salary));
	}
	
	@Override
	public LinkedList<Employee> listEmployeesSorted(){
		return (LinkedList<Employee>) employees;
	}

}
