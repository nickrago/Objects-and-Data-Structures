package lab08;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class labTester {
	@Test
	@DisplayName("Factorial Tester")
	public void test1(){
		assertEquals(1, Recursion.factorial(0)); //base case 0
		assertEquals(1, Recursion.factorial(1)); //base case 1
		assertEquals(479001600, Recursion.factorial(12));
	}
	
	@Test
	@DisplayName("Sqrt Tester")
	public void test2(){
		assertEquals(0, Recursion.squareRoot(0)); //base case 0
		assertEquals(25, Math.floor(Recursion.squareRoot(625))); //math.floor is used to compensate for extraneous decimals after correct answer. this would not be used for non-perfect roots
	}
	
	@Test
	@DisplayName("List Sum Tester")
	public void test3(){
		List<Integer> test = new ArrayList<>();
		test.add(1); test.add(2); test.add(3);
		assertEquals(6, Recursion.sum(test)); //list of 3 non-null elements
	}
	
	@Test
	@DisplayName("Array Sum Tester")
	public void test4(){
		int test[] = {10,25,37};
		assertEquals(72, Recursion.sum(test)); //array of 3 ints
	}
	
	@Test
	@DisplayName("Binomial Coefficient Tester")
	public void test5(){
		assertEquals(10, Recursion.binomialCoefficient(5, 2)); // k < n/2
		assertEquals(210, Recursion.binomialCoefficient(10, 6)); // k > n/2
		
	}
}