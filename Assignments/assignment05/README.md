# assignment05
Assignment 5
Due Friday 3/15 11:59pm

# Given Instructions

Override public int compareTo(Person o) as follows:

The return value is set to lastName.compareToIgnoreCase(o.lastName)
If the return value is 0, change it the corresponding comparison for firstName
If even this return value is 0, change it to dob.compareTo(o.dob)
Return this return value. 

Override the toString method, using StringBuilder sb. There must not be any "+" concatenations in this method. Start with sb = new StringBuilder(firstName), append a space, append lastName, append " (", append dob, append ")" and return sb.toString(). A Person will now print out in the form: Isaac Calhoun (1976-11-02). 

Make a subinterface Employer of Comparable<Employer>:
 
public interface Employer extends Comparable<Employer> 

As you proceed, use CTRL+SHIFT+O or the Mac equivalent (look under Source->Organize imports) to do imports  
 
The abstract method in Employer will be List<Employee> listEmployees();

CORRECTION:

Also Override the compareTo method as a default method: default int compareTo(Employer o), which returns toString().compareToIgnoreCase(o.toString())

Also provide a default method default List<Employee> listEmployeesSorted(), which makes a List<Employee> temp instantiated as a new ArrayList, then calls temp.addAll(listEmployees()) get get all the Employees into a new temporary list, then calls Collections.sort(temp) to sort this copy and returns temp.

Note that listEmployees is going to return the actual list of employees of a company and we don't want to sort that list and change its ordering permanently. Hence we make a copy. ALSO the list of employees may not even be an ArrayList.

Using CTRL+SHIFT+O or the Mac equivalent (look under Source->Organize imports) should import ArrayList, Collections, and List from java.util. 

Make a class Employee that implements Comparable<Employee>. There are 3 private fields: Person person, double salary, Employer employer.  The constructor ONLY sets person and salary.

Provide a getter method for person, and both getter and setter methods for salary and employer. Provide a method public double increase(double pct) than increases salary by the percentage pct and returns the new salary.

Override public int compareTo(Employee o) to return person.compareTo(o.person). This compareTo can be used to sort Employees according to their names.

Override toString to return person + String.format(" %s: $%,.2f", employer, salary). Note that the textbook describes how to use System.out.printf on pages 146 and 147, and String.format uses the same formatting specifiers. The best thing is that salaries are printed with 2 decimal places and commas between the thousands.

Make a class Company that implements Employer. The private fields are String companyName and List<Employee> employees instantiated as an empty ArrayList 

Provide a constructor that ONLY sets the companyName.

Override toString to return "Company: " + companyName

Override public List<Employee> listEmployees() to return employees

Write a method public void addEmp(Employee e), which FIRST calls e.setEmployer(this), to pass "this" Company object to set the Employer of e, and then adds e to employees.

Write a method public void addPerson(Person p, double salary) that calls addEmp(new Employee(p, salary))

Just for variety make a class public class SmallCompany implements Employer with the private fields String companyName and List<Employee> employees = new LinkedList<>().

The constructor sets companyName.

The methods toString, addPerson, listEmployees should be copied from Company.

The method addEmp will be different and is written to keep the list of employees in sorted order. Here is the code. Remind me to discuss it again when we cover Chapter 14.

public void addEmp(Employee e) {
	e.setEmployer(this);
	int k = Collections.binarySearch(employees, e);
	if(k < 0) employees.add(-k-1,e);
}
 
This method also prevents the same Person being added twice as an employee.

Also Override the default method public List<Employee> listEmployeesSorted() to return employees. This works since the list is being kept sorted at all times. Note also that this method now returns a LinkedList rather than an ArrayList.

Make a class Tester1 with a main method to see Comparators in action.

In the main method, start with an array of 10 Strings called cNames for names of Companies. I have {"A", "B", "W", "H", "J", "E", "P", "C", "G", "F"} but you should be a bit more creative!

Make a random array of 100 Person objects:

Random rand = new Random();
Person[] people = new Person[100];
for(int i = 0; i < 100; i++) people[i] = Resources.getPerson();
Make an array cs of Company elements with length 6 and an array scs of SmallCompany elements of length 4.

Create an int variable salary set to 0.

In a loop for i from 0 to 5 (i.e. i < 6), set cs[i] to a new Company with name cNames[i]. Then in a nested loop for j from 0 to 9 (i.e. j < 10), if j is even, set salary to 40_000 + rand.nextInt(60_000). The underscore only works in the more recent versions of Java. end the inner loop with cs[i].addPerson(people[10*i+j], sal).

In a loop for i from 0 to 3 (i.e. i < 4), set scs[i] to a new Company with name cNames[i+6]. Then in a nested loop for j from 0 to 9 (i.e. j < 10), follow the same steps as above, except replace people[10*i+j] with people[60+10*i+j] to make sure we use different Person objects in the csc array.
 
The following prints should show that you have build companies with 10 employees and that the SmallCompany keeps its employees in sorted order (the 3rd and 4th lines are in the same order).

System.out.println(cs[5].listEmployees());
System.out.println(cs[5].listEmployeesSorted());
System.out.println(scs[3].listEmployees());
System.out.println(scs[3].listEmployeesSorted());
 
Collect all the employees into one list as follows

List<Employee> all = new ArrayList<>();
for(var c : cs) all.addAll(c.listEmployees());
// do the corresponding loop for scs
System.out.println(all);
 
Keep running the main has we progress to see the effect of each step.

Comparator<Employee> c1 = Comparator.comparingDouble(e -> e.getSalary());		
// we discussed comparingDouble in class for sorting ellipses in class on Friday
Collections.shuffle(all);
Collections.sort(all, c1);
System.out.println(all);
 
Replace e -> e.getSalary() by Employee::getSalary, i.e.

Comparator<Employee> c1 = Comparator.comparingDouble(Employee::getSalary);
So when the method that extracts the double already exists, we have an alternate way to define it.

Next add the lines

Comparator<Employee> c2 = c1.reversed();	
Collections.shuffle(all);
Collections.sort(all, c2);
System.out.println(all);
The print out now lists the Person objects with the largest salaries first.

Do the same 4 lines with each of the following comparators:

Comparator<Employee> c3 = Comparator.comparing(Employee::getEmployer) which will list Person objects grouped by their Company name
Comparator<Employee> c4 = Comparator.comparing(Employee::getPerson) which will list Person objects grouped by their own name (and date of birth if the names are the same).
Comparator<Employee> c5 = c3.thenComparing(c2) which will list the Person objects groups by their Company and then in each group in order of the salary, starting with the highest. NOTE that we gave pairs of people in the companies the same salary so those will appear together,
Comparator<Employee> c6 = c3.thenComparing(c2).thenComparing(c4) which will list the Person objects groups by their Company and then in each group in order of the salary, starting with the highest but when the salaries are the same the Person objects will be in their order of name (and date of birth if the names are the same).
 
In Tester1, make a method public static Comparator<Employee> makeComparator() that repeats the steps in making c1, c2, c3, c4, c6 and returns c6.

Make a JUnit test that tests the method Tester1.makeComparator(). Since it is a comparator produced by library code, we can assume that it satisfies c6(a, b) = - c6(b, a) so we only need to change c6(a, b) > 0 for the expected values of a and b. However we want to check the values are correct (positive) when

the companies of a and b are different but the salaries and names are in the reverse order,
the company names are the same, the salaries are different but the names are in reverse order,
the company names and salaries are the same and the last names are different and the first names and dates of birth are in the reverse order,
the company names and salaries are the same, the last names are the same and the first names are different and the sates of birth are in the reverse order,
the company names and salaries are the same, the first and last names are the same and the dates of birth are different.

Make a class public class University implements Comparable<University> with fields

private String name;
private List<Person> faculty;
private List<Person> staff;
private List<Person> students;
The constructor only has 1 parameter to set the name of the university and also instantiates the 3 lists to new, empty ArrayLists. Provide a getter method for name.

Write a compareTo(Univesity arg) method that returns the size() of this University;s students list minus the size() of arg's students.

 

Write a method public Comparator<University> makeComparator() which makes Comparator<University> nameComp = (u1, u2) -> u1.getName().compareToIgnoreCase(u2.getName()); and then makes

 

Comparator<University> natural = Comparator.naturalOrder();
Comparator<University> descending = natural.reversed();
and returns descending.thenComparing(nameComp)

 

The purpose is that Universities are ordered with the largest number of students first. If 2 Universities have exactly the same number of students, they will be ordered by name.

 

Continue your JUnit test to test University.makeComparator(), checking larger numbers of students come first (< 0), even when the names are not in order and if the student numbers are the same, then the names of the universities are in alphabetical order.

 

There github starter code for assignment05 is HERE

 

Just for fun, here is an implementation of the Conway's Game of Life. There are 4 classes in the repository Cell,java, CellGrid.java, GoLdriver.java, LifePanel.java. There is one TODO on line 41 of GoLdriver: once you are sure you can open, control, and close the GUI by using the keyboard (X followed by Yes gets you out--I hope it works on the Mac), you can change false to true on line 41.

 

The big TODOs are in Cell.java: (i) to populate the array of neighbors and (ii) to count how many neighbors are alive on each cycle.

 

The textbook described the problem on Page 369. Section 7.6.3 --please let me know if you do not have access to these pages--shows the array index locations of the neighbors.

neighbors[0] is the upper left neighbor
neighbors[1] is the upper center neighbor
neighbors[2] is the upper right neighbor
neighbors[3] is the left neighbor
neighbors[4] is the right neighbor
neighbors[5] is the lower left neighbor
neighbors[6] is the lower center neighbor
neighbors[7] is the lower right neighbor
 

The entry neighbors[k] remains null for some values of k if the cell under consideration is in a corner or along an edge. For example in the top-right corner, neighbors[k] is null for k = 0, 1, 2, 4, 7.

 
