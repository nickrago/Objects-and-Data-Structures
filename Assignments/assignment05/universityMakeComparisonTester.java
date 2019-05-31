package assignment05;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.Comparator;
import org.junit.jupiter.api.Test;

public class universityMakeComparisonTester {
	/* The code seems logically correct to me, I can't figure out where I'm going wrong.
	 * I believe however, that I am adding the students incorrectly.
	 * 
	 * 
	 * 
	//two universities with the same number of students
	@Test
	public void test1(){
		University borhamtom = new University("bhu");
		University carnoll = new University("cnu");
		Person b1 = new Person("Brandon", "Smith", LocalDate.of(2000, 4, 24));
		Person b2 = new Person("Bill", "Locke", LocalDate.of(1999, 5, 25));
		Person b3 = new Person("Bornethius", "Archibald", LocalDate.of(1998, 6, 26));
		
		Person c1 = new Person("Chris", "O'Ryan", LocalDate.of(1998, 6, 26));
		Person c2 = new Person("Connor", "Dickinson", LocalDate.of(1999, 5, 25));
		Person c3 = new Person("Cameron", "Blink", LocalDate.of(2000, 4, 24));
		
		borhamtom.addStudent(b1);
		borhamtom.addStudent(b2);
		borhamtom.addStudent(b3);
		
		carnoll.addStudent(c1);
		carnoll.addStudent(c2);
		carnoll.addStudent(c3);

		assertEquals(borhamtom.compareTo(carnoll), 0);
	}
	
	//two universities with the different number of students
		@Test
		public void test2(){
			University borhamtom = new University("bhu");
			University carnoll = new University("cnu");
			Person b1 = new Person("Brandon", "Smith", LocalDate.of(2000, 4, 24));
			Person b2 = new Person("Bill", "Locke", LocalDate.of(1999, 5, 25));
			Person b3 = new Person("Bornethius", "Archibald", LocalDate.of(1998, 6, 26));
			Person b4 = new Person("Balance", "Isbig", LocalDate.of(1997, 3, 23));
			Person b5 = new Person("Barron", "Rockefeller", LocalDate.of(1996, 2, 22));
			
			Person c1 = new Person("Chris", "O'Ryan", LocalDate.of(1998, 6, 26));
			Person c2 = new Person("Connor", "Dickinson", LocalDate.of(1999, 5, 25));
			Person c3 = new Person("Cameron", "Blink", LocalDate.of(2000, 4, 24));
			
			borhamtom.addStudent(b1);
			borhamtom.addStudent(b2);
			borhamtom.addStudent(b3);
			borhamtom.addStudent(b4);
			borhamtom.addStudent(b5);
			
			carnoll.addStudent(c1);
			carnoll.addStudent(c2);
			carnoll.addStudent(c3);

			assertTrue(borhamtom.compareTo(carnoll) > 0);
		}
	*/
}
