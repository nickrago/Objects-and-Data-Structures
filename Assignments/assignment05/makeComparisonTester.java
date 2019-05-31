package assignment05;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Comparator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class makeComparisonTester {
	
	//the companies of a and b are different but the salaries and names are in the reverse order
	@Test
	public void test1(){
		Person p1 = new Person("Shawn", "Bailey", LocalDate.of(1993, 4, 25));
		Person p2 = new Person("John", "Fetcher", LocalDate.of(1992, 3, 20));
		Company c1 = new Company("Binghamton University");
		Company c2 = new Company("Apple");
		double salary1 = 1000;
		double salary2 = 2000;

		Employee a = new Employee(p1, salary1);
		Employee b = new Employee(p2, salary2);
		a.setEmployer(c1);
		b.setEmployer(c2);

		Comparator<Employee> comp = Tester1.makeComparator();
		assertTrue(comp.compare(a,b) > 0);
		
		//reverse the Person and salaries, but keep the companies the same for each employee
		a = new Employee(p2, salary2);
		b = new Employee(p1, salary1);
		a.setEmployer(c1);
		b.setEmployer(c2);

		//if we reverse the people and their salaries, it doesn't matter.
		//a and b are compared based on their employer
		assertTrue(comp.compare(a,b) > 0);
	}
	
	//the company names are the same, the salaries are different but the names are in reverse order
	@Test
	public void test2(){
		Person p1 = new Person("Shawn", "Bailey", LocalDate.of(1993, 4, 25));
		Person p2 = new Person("John", "Fetcher", LocalDate.of(1992, 3, 20));
		Company c = new Company("Apple");
		double salary1 = 1000;
		double salary2 = 2000;

		Employee a = new Employee(p1, salary1);
		Employee b = new Employee(p2, salary2);
		a.setEmployer(c);
		b.setEmployer(c);

		Comparator<Employee> comp = Tester1.makeComparator();
		assertTrue(comp.compare(a,b) > 0);
		
		a = new Employee(p2, salary1);
		b = new Employee(p1, salary2);
		a.setEmployer(c);
		b.setEmployer(c);

		assertTrue(comp.compare(a,b) > 0);
	}
	
	//the company names and salaries are the same and the last names are different and the first names and dates of birth are in the reverse order
	@Test
	public void test3(){
		Person p1 = new Person("John", "Bailey", LocalDate.of(1992, 3, 20));
		Person p2 = new Person("Shawn", "Fetcher", LocalDate.of(1993, 4, 25));
		Company c = new Company("Apple");
		double salary = 1000;
		
		Employee a = new Employee(p1, salary);
		Employee b = new Employee(p2, salary);
		a.setEmployer(c);
		b.setEmployer(c);

		Comparator<Employee> comp = Tester1.makeComparator();
		assertFalse(comp.compare(a,b) > 0);
		
		a = new Employee(p2, salary);
		b = new Employee(p1, salary);
		a.setEmployer(c);
		b.setEmployer(c);

		assertTrue(comp.compare(a,b) > 0);
	}
	
	//the company names and salaries are the same, the last names are the same and the first names are different and the sates of birth are in the reverse order
	@Test
	public void test4(){
		Person p1 = new Person("John", "Bailey", LocalDate.of(1992, 3, 20));
		Person p2 = new Person("Shawn", "Bailey", LocalDate.of(1993, 4, 25));
		Company c = new Company("Apple");
		double salary = 1000;
		
		Employee a = new Employee(p1, salary);
		Employee b = new Employee(p2, salary);
		a.setEmployer(c);
		b.setEmployer(c);

		Comparator<Employee> comp = Tester1.makeComparator();
		assertFalse(comp.compare(a,b) > 0);
		
		a = new Employee(p2, salary);
		b = new Employee(p1, salary);
		a.setEmployer(c);
		b.setEmployer(c);

		assertTrue(comp.compare(a,b) > 0);
	}
	
	//the company names and salaries are the same, the first and last names are the same and the dates of birth are different
	@Test
	public void test5(){
		Person p1 = new Person("Shawn", "Bailey", LocalDate.of(1994, 3, 20));
		Person p2 = new Person("Shawn", "Bailey", LocalDate.of(1993, 4, 25));
		Company c = new Company("Apple");
		double salary = 1000;
		
		Employee a = new Employee(p1, salary);
		Employee b = new Employee(p2, salary);
		a.setEmployer(c);
		b.setEmployer(c);

		Comparator<Employee> comp = Tester1.makeComparator();
		assertTrue(comp.compare(a,b) > 0);
		
		a = new Employee(p2, salary);
		b = new Employee(p1, salary);
		a.setEmployer(c);
		b.setEmployer(c);

		assertFalse(comp.compare(a,b) > 0);
	}

}
