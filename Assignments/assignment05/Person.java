package assignment05;

import java.time.LocalDate;

public class Person implements Comparable<Person> {
	String firstName; 
	String lastName; 
	LocalDate dob;
	
	public Person(String firstName, String lastName, LocalDate dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
	}
	
	@Override
	public int compareTo(Person o) {
		int returnVal = lastName.compareToIgnoreCase(o.lastName);
		if(returnVal == 0) returnVal = firstName.compareToIgnoreCase(o.firstName);
		if(returnVal == 0) returnVal = dob.compareTo(o.dob);
		return returnVal;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(firstName);
		sb.append(" ");
		sb.append(lastName);
		sb.append(" (");
		sb.append(dob);
		sb.append(")");
		return sb.toString();
	}	
	
	
}
