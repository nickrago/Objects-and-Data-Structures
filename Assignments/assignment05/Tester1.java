package assignment05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Tester1 {
	public static void main(String[] args) {
		String[] cNames = {"Arnolds Animals", "Bobs Balloons", "Will's Walls", "Harold's Haircuts", "John's Jeans", "Earl's Earrings", "Peter's Pants", "Chris' Chairs", "George's Grains", "Frank's Footwear"};
		Random rand = new Random();
		Person[] people = new Person[100];
		
		for(int i = 0; i<100; i++) people[i] = Resources.getPerson();
		Company[] cs = new Company[6];
		SmallCompany[] scs = new SmallCompany[4];
		
		int salary = 0;
		for(int i = 0; i<6; i++) {
			cs[i] = new Company(cNames[i]);
			for(int j = 0; j<10; j++) {
				if(j%2 == 0) salary = 40_000 + rand.nextInt(60_000);
				cs[i].addPerson(people[10*i+j], salary);
			}
		}
		for(int i = 0; i<4; i++) {
			scs[i] = new SmallCompany(cNames[i+6]);
			for(int j = 0; j<10; j++) {
				if(j%2 == 0) salary = 40_000 + rand.nextInt(60_000);
				scs[i].addPerson(people[60+10*i+j], salary);
			}
		}
		
		/*
		System.out.println(cs[5].listEmployees());
		System.out.println(cs[5].listEmployeesSorted());
		System.out.println(scs[3].listEmployees());
		System.out.println(scs[3].listEmployeesSorted());
		*/
		
		List<Employee> all = new ArrayList<>();
		for(var c : cs) all.addAll(c.listEmployees());
		for(var c : scs) all.addAll(c.listEmployees());
		//System.out.println(all);
		
		Comparator<Employee> c1 = Comparator.comparingDouble(Employee::getSalary);		
		Collections.shuffle(all);
		Collections.sort(all, c1);
		System.out.println(all);
		
		Comparator<Employee> c2 = c1.reversed();	
		Collections.shuffle(all);
		Collections.sort(all, c2);
		System.out.println(all);
		
		Comparator<Employee> c3 = Comparator.comparing(Employee::getEmployer);
		Collections.shuffle(all);
		Collections.sort(all, c3);
		System.out.println(all);
				
		Comparator<Employee> c4 = Comparator.comparing(Employee::getPerson);
		Collections.shuffle(all);
		Collections.sort(all, c4);
		System.out.println(all);
		
		Comparator<Employee> c5 = c3.thenComparing(c2);
		Collections.shuffle(all);
		Collections.sort(all, c5);
		System.out.println(all);
		
		Comparator<Employee> c6 = c3.thenComparing(c2).thenComparing(c4);
		Collections.shuffle(all);
		Collections.sort(all, c6);
		System.out.println(all);
		
	}
	
	public static Comparator<Employee> makeComparator(){
		Comparator<Employee> c1 = Comparator.comparingDouble(Employee::getSalary);
		Comparator<Employee> c2 = c1.reversed();
		Comparator<Employee> c3 = Comparator.comparing(Employee::getEmployer);
		Comparator<Employee> c4 = Comparator.comparing(Employee::getPerson);
		Comparator<Employee> c6 = c3.thenComparing(c2).thenComparing(c4);
		return c6;
	}
}
