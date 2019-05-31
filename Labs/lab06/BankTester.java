package lab06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class BankTester {
	List<BankAccount> accounts;
	List<Object> objects;
	//we can initialize some objects to be used in later tests
	//using the BeforeEach keyword ensures this method is called before 
	//the test methods are called
	
	//Please note that this method is rerun before the start of each test,
	//which means the BankAccounts will have their numId's increased 
	//each time the account is called.
	
	//we will fix this issue by adding an @AfterEach method, which is run 
	//after each test ends
	@BeforeEach
	void initialize(){
		List<BankAccount> accounts = new ArrayList<>();
		accounts.add(new BankAccount(500.00));
		accounts.add(new BankAccount(20.00));
		accounts.add(new SavingsAccount(1000.00, 0.05));
		accounts.add(new SavingsAccount(50.00, 0.5));
		accounts.add(new CheckingAccount(5000.00, 5));
		accounts.add(new CheckingAccount(100.00, 10));
		
		
		objects.add(500);
		objects.add("Hello");
		objects.add(10.0);
		objects.add(false);
		
	}

	@AfterEach
	void resetIdNum(){
		BankAccount.reset();
		accounts.clear();
	}
	
	
	//the @Test is necessary, without it the test will not be run
	@Test
	@DisplayName("Tests deposit method of bank account")
	void testBankAccDeposit() {
		BankAccount bacc = new BankAccount(700.00);
		bacc.deposit(100);
		try {
			//when comparing two doubles, we need to give it some small value for it to see 
			//if the expected and actual value are close enough to equaling one another
			assertEquals(800.00, bacc.getBalance(), 1e-6);
		}
		//here if there is an assertion error, we can catch it 
		//and print the error message out, then throw the AssertionError
		//so that the test still fails. 
		catch(AssertionError e){
			System.out.println("BankAccount's deposit() method failed: " + e.getMessage());
			throw e;
		}
	}
	@Test
	@DisplayName("Tests withdraw method of checking account")
	void testCheckingAccWithdraw(){
		CheckingAccount checking = new CheckingAccount(1000.00, 10);
		for(int i = 0; i < 3; i++) checking.withdraw(100);
		try {
			//when comparing two doubles, we need to give it some small value for it to see 
			//if the expected and actual value are close enough to equaling one another
			assertEquals(700.00, checking.getBalance(), 1e-6);
		}
		//here if there is an assertion error, we can catch it 
		//and print the error message out, then throw the AssertionError
		//so that the test still fails. 
		catch(AssertionError e){
			System.out.println("CheckingAccount's withdraw() method failed: " + e.getMessage());
			throw e;
		}
	}
	@Test
	@DisplayName("Tests getter for withdrawCount of a CheckingAccount")
	void testCheckingAccGetWithdrawCount(){
		CheckingAccount checking = new CheckingAccount(1000.00, 10);
		for(int i = 0; i < 3; i++) checking.withdraw(100);
		try {
			//when comparing two integers, we don't need a third argument 
			//since ints can be checked for equality
			assertEquals(3, checking.getWithdrawCount());
		}
		//here if there is an assertion error, we can catch it 
		//and print the error message out, then throw the AssertionError
		//so that the test still fails. 
		catch(AssertionError e){
			System.out.println("CheckingAccount's getWithdrawCount() method failed: " + e.getMessage());
			System.out.println("Make sure you adjust the withdrawCount in your CheckingAccount's withdraw() method!");
			throw e;
		}
	}
	
	//TODO: Finish out these seven additional tests. Keep each test in a separate test function.
	//This isolates testing a single method or case to a single testing method. Otherwise, 
	//if you try to do too much testing in one tester method, you could throw an error
	//for a test and never find the errors of the other tests you put in that method.
	//Alternatively, you could use assertAll. 
	
	@Test
	@DisplayName("Tests deposit to a Savings Account")
	void testSavingsAccDeposit(){
		SavingsAccount saving = new SavingsAccount(700.00, 0.5);
		saving.deposit(100);
		try {
			assertEquals(850.00, saving.getBalance(), 1e-6);
		} 
		catch(AssertionError e){
			System.out.println("SavingsAccount's deposit() method failed: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	@DisplayName("Exceeds the withdraw limit of a Checking Account")
	void testExceedingCheckingWithdraw() {
		CheckingAccount checking = new CheckingAccount(1000.00, 2);
		checking.withdraw(50.0);
		checking.withdraw(100.0);
		try {
			assertEquals(0, checking.withdraw(150.0));
			assertEquals(2, checking.getWithdrawCount());
		}
		catch(AssertionError e) {
			System.out.println("CheckingAccount's withdraw() method failed: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	@DisplayName("Tests BankAccount's withdraw where amt <= balance")
	void testTypicalBankAccWithdraw() {
		BankAccount bacc = new BankAccount(700.00);
		try {
			assertEquals(100.00, bacc.withdraw(100.00));
			assertEquals(600.00, bacc.getBalance());
		}
		catch(AssertionError e) {
			System.out.println("BankAccount's withdraw method failed: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	@DisplayName("Tests BankAccount's withdraw where amt > balance")
	void testEmptyOutBankAccViaWithdraw() {
		BankAccount bacc = new BankAccount(700.00);
		try {
			assertEquals(700.00, bacc.withdraw(1000.00));
			assertEquals(0, bacc.getBalance());
		}
		catch(AssertionError e) {
			System.out.println("BankAccount's withdraw method failed: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	@DisplayName("Tests BankAccount's toString()")
	void testBankAccToString() {
		BankAccount bacc = new BankAccount(700.00);
		try {
			assertEquals("Acct. #" + bacc.getIdNum() + " has $" + bacc.getBalance(), bacc.toString());
		}
		catch(AssertionError e) {
			System.out.println("BankAccount's toString method failed: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	@DisplayName("Tests CheckingAccount's toString()")
	void testCheckingAccToString() {
		CheckingAccount checking = new CheckingAccount(1000.00, 2);
		try {
			assertEquals("Acct. #" + checking.getIdNum() + " has $" + checking.getBalance() + " (0/2)", checking.toString());
		}
		catch(AssertionError e) {
			System.out.println("CheckingAccount's toString method failed: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	@DisplayName("Tests SavingsAccount's toString()")
	void testSavingsAccToString() {
		SavingsAccount saving = new SavingsAccount(700.00, 0.5);
		try {
			assertEquals("Acct. #" + saving.getIdNum() + " has $" + saving.getBalance() + " @ " + (saving.getRate() * 100) + "%", saving.toString());
		}
		catch(AssertionError e) {
			System.out.println("SavingsAccount's toString method failed: " + e.getMessage());
			throw e;
		}
	}
	
	//TODO: time to do some things showcasing Dynamic Dispatching
	@Test
	@DisplayName("prints based off dynamic dispatching")
	void dynamicDispatchPrinting(){
		for(BankAccount b : accounts) {
			if(b instanceof SavingsAccount) {
				System.out.println("SavingsAccount: ");
			}
			else if(b instanceof CheckingAccount) {
				System.out.println("CheckingAccount: ");
			}
			else {
				System.out.println("BankAccount: ");
			}
			System.out.println(b);
		}
		for(var v : objects) {
			System.out.println(v);
		}
	}

}
