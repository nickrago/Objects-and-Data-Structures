# lab06

Introduction to Eclipse, Subclassing, and JUnit Testing

# Given Instructions

We will now switch where we develop code from Gedit and the terminal to the Eclipse IDE (Integrated Development Environment). Eclipse integrates many tools as well as third-party plug-ins into one desktop application for software development. Eclipse offers package explorer, text editor, and console output windows, among others.

You may want to download Eclipse for your personal computer. It is available for Windows, Mac, and Linux here.

You should familiarize yourself with the Ctrl-A Ctrl-I shortcut which automatically reformats your source code to the proper indentation levels. Use this often - mis-indented or unindented code is challenging to write, read, and grade.

From now on, you may use your own computers in the lab room. If you decide not to do so, then use the VDI located here.

Click on HTML Access
At the login, make sure to select PODS rather than BGM
Login and wait for centos to pop up, may take a few minutes

Running Eclipse for the first time

Assuming you are in the VDI, open Eclipse by going to Applications -> Programming -> Eclipse Oxygen. It usually takes a while to load the first time. Again, you may also use Eclipse  on your laptop if you want.

Once eclipse is running:

open up a terminal
mkdir cs140-eclipse inside the U-drive directory
WARNING: if you don't put it in your U-drive you risk losing your work! this happened to me preparing for today's lab
select a workspace directory where Eclipse will put all the files you create within it.
make this cs140-eclipse. hit browse to select the path easily
Close out the welcome screen that appears, you can also check a box near the bottom to stop it from appearing in the future
Create a new Java project via File->New->Other->Java Project.
Enter cs140 for the project name and click Finish.
It it asks you to create module-info.java select don't create. If you do accidentally create it, simply right click it and delete it.
once this is done, you show see a blue folder with the name we specified.
if you expand it, you will see a JRE System Library for Java11 and a also a src folder.
the src folder will be where we put all our code for each lab and assignment
We need to add Junit5 to this java project
Right click the blue folder of the java project, then hit Build Path->Add Libraries. Select Junit, and then make sure you add Junit5.
Most of the setup for Eclipse is now done. If you set up eclipse on your own personal computer, these steps will also be a useful guide.

Using Github to grab lab06

Now that you have made your java project, we will show you how to clone this repository into eclipse via the terminal.

 

back in the terminal, cd into cs140-eclipse
if  you ls, you should see cs140. cd into cs140
if you ls, you should see bin and src. cd into src
as usual, go ahead and clone lab06 into this src directory. Here is the link to accept lab06.
IMPORTANT: now, we need to change the name of the cloned folder. Our folder must match the package name, so we need to remove our -gitusername
we do this via the mv command, which stands for move
mv lab06-sbailey6 lab06
back in Eclipse, hit File -> Refresh
This will make lab06 appear in cs140/src

Congratulations, you just cloned your first git repository and linked it up with Eclipse! You can do all other git related things in the lab06 folder via the terminal, as we have done in the past. 

In addition to getting comfortable with Eclipse and some ways it can make life easier, we will be working with subclasses and JUnit testing today.

Some notes on the toString method
  
The Object class is the root class of all classes. If you don't declare a class to extend another class, it implicitly extends the Object class. Since the Object class implements the toString method, all classes have a toString method. By default though, it just returns the object's memory address so we typically override it to something meaningful. For instance, the way the ArrayList class implements its toString is to build a comma-separated list of each of its elements' toString methods.

Since all Objects have the toString method, we can always call it on any instance of any Object. Given this fact and that programmers often want to convert complex objects into digestible Strings, Java will call toString implicitly when we print that object.

So instead of writing System.out.println(myArrayList.toString()); you should write System.out.println(myArrayList); which will automatically invoke toString for non-nulls.

This is not just less to type, it is less error-prone. If myArrayList or whatever Object you're printing happened to be null, you would get a NullPointerException from explicitly calling toString on a null Object. By just referring to the variable, Java will automatically first check if its value is null and only if it is not null will it then call toString on it.

Classes and subclasses

In eclipse's lab06 package, create a class BankAccount by right clicking the lab06 package, and selecting New -> Class. Specify the name BankAccount and hit Finish.

 

BankAccount has the following private fields:

 

double balance 
int idNum 
static int numAccounts, initialized to 0  
 
Create a constructor that accepts a double bal and assigns that to the balance field.
If the given bal is negative, throw an IllegalArgumentException, with a meaningful error message.
Additionally in the constructor, assign numAccounts to idNum and then increment `numAccounts`.
Since numAccounts is a static field, it is shared across all instances of the BankAccount class.
This is different than balance because we want balance to be unique to each BankAccount.
This static field and constructor pattern is an easy way to assign each instance of a class a unique identifying number. An id number gives us a way to distinguish two bank accounts that may happen to have the same balance.
Create a getter for balance and idNum.
You can have eclipse automatically do this for you. Hit Source, and select Generate Getters and Setters....
only generate getters, deselect the generation for setters
Create a method static void reset() which sets numAccounts equal to zero.
This method does not need to have public in its method header, it is package private.
This will be used to ensure that your idNums are not off when the @BeforeEach method in your JUnit tester is being rerun multiple times. (More details on that later).
Override the toString method, paying attention to add the annotation:
@Override // good habit to include
public String toString() {
    // should return the string "Acct. #3 has $50.0" for an account with idNum = 3 and balance = 50
}
The @Override annotation asks the compiler to make sure we are overriding (redefining) an inherited method (from the Object superclass) instead of making a different one. So if we misspelled toString, had a different method header, or gave the wrong return type, the compiler would give an error.
Provide a method public void deposit(double amount) that adds amount additional dollars into the account's balance.
If amount is negative, throw an IllegalArgumentException, explaining deposits must be done with positive values.
Provide a method public double withdraw(double amount).
This method attempts to withdraw amount of money from balance.
This method withdraws as much as possible (at most amount) from the account and returns the amount being withdrawn.
The reason the return value might not be equal to the amount argument is if the account does not have enough money to cover the full withdraw.
This logic should prevent an account from having a negative balance.
If amount is negative, throw an IllegalArgumentException, explaining withdrawals must be done with positive values.

Now for the interesting part: subclassing.


Create a class SavingsAccount that extends the BankAccount class.
We say that SavingsAccount subclasses (is a subclass of) BankAccount and that BankAccount is the superclass/parent class of SavingsAccount.
When class A subclasses class B, this leads some people to say "A is a B". For example, if Dog subclasses Animal, Dog is an Animal.
Other common terminology is the parent is the base class and the child is a derived class
By subclassing BankAccount, SavingsAccount inherits all the non-private methods and fields. This means it gets access to the use of deposit, withdraw, etc., but not access to the balance nor idNum fields, even though those fields are stored in any SavingsAccount object. But this is okay since it inherits the public getter methods to those fields. A SavingsAccount is like a BankAccount but gets interest on each deposit.
Give SavingsAccount a private double field named rate.
Make a constructor that accepts a double balance and a double rate. Here, the rate should be assumed to be some decimal between 0 and 1.
When a class subclasses another, its constructor has the option to call the superclass's constructor as the first line of its constructor. We do this with the keyword super.

Example:


 

 

class Parent {
    private int i;
    public Foo(int i) {
        this.i = i;
    }
}

class Child extends Parent { // subclassing/inheritance
    private boolean b;
    public Foo(int i, boolean b) {
        super(i); // must be first line of constructor
        this.b = b;
    }
}

Using the above example as a guide, call BankAccount's constructor, passing in the balance parameter from the SavingsAccount constructor. Then use the rate parameter to assign to the rate field. If rate is negative, throw an IllegalArgumentException explaining the rate cannot be negative.

Next, we want to override the deposit method. Instead of inheriting the same method, we want to change its behavior from that of BankAccount.

We override by copying the method signature exactly and following the good habit of adding the @Override annotation.

SavingsAccount's deposit method should not only deposit the given balance, but also an additional rate percent of it. So if I construct a SavingsAccount with a 0.1 rate and deposit $10, $11 should actually be added (10 + 0.1*10). The issue is balance is private within BankAccount so SavingsAccount cannot get at it directly nor is there a setter method. Instead we can use the BankAccount deposit method and send in the proper amount. You can call the parent's version of the method, say methodName(), within its subclass by doing super.methodName();

Now knowing how to call a super class method, implement SavingsAccount's deposit method by calling the superclass's (BankAccount) deposit method with the proper inflated amount.

Provide a getter for rate.

Override the toString method to return the superclass's toString, concatenated with " @ N%" where N represents the rate of the savings account as a percent. For example, an account with id number 5 and balance 100 at rate 0.05, would give a string of "Acct. #5 has $100 @ 5.0%". No credit will be given for duplicating the code to print out the first portion, you must call the superclass's toString.

Create a class CheckingAccount, also a subclass of BankAccount. A CheckingAccount is like a BankAccount, but has a limit on how many withdraws are allowed (i.e. how many checks you can write).

A CheckingAccount should have two private integer fields, one named withdrawLimit and another named withdrawCount, initialized to 0.

Provide the class a constructor that accepts a double balance and an int limit. Pass the balance to superclass constructor and assign the limit parameter into the withdrawLimit field. If limit is less than 1, throw an IllegalArgumentException explaining the Withdrawl limit must be positive.

Provide a getter for withdrawLimit and withdrawCount. Recall you can have eclipse generate them for you. 

Override toString to return the superclass's toString, concatenated with " (C/L)" where C is the withdrawCount and L is the withdrawLimit. The "/" is the literal forward-slash character, do not divide C by L.

Override the withdraw method. If the withdrawCount is less than the withdrawLimit, call the superclass's withdraw method and return the value it returns. Also increment the withdrawCount as we have just written a check. If the withdrawCount is at or above the withdrawLimit, return 0 to signify nothing was withdrawn.

Subclassing Caveats - For your reference

 

We have provided an additional file for you to play around with the ideas of the instanceof keyword, and also Up Casting and Down Casting. It is meant as a reference for you and understanding some of the caveats that come along with subclassing. 

JUnit Tester

With these classes written, we now want to test them. We could do it the way we're familiar with: create a Tester class with a main method that prints out what is expected and what is received but this is error prone. This leaves the user to visually inspect both results and assert they're equal. It also means that if one test of a method throws an exception or goes into an unexpected state, any further tests may not be run or may run incorrectly.
That's why we will now be shifting our testing to be with JUnit, the Java unit-testing framework.

Take a look at BankTester which has been provided for you already. You can read about some of the things you can do with JUnit testing here.

Every test case that we want to test will correspond to one test method in the Junit class. Notice that the test method has a @Test annotation. Every method you want JUnit to test must have one of these or that method won't be called. The name of the test does not matter but it should describe what you're testing. You can also add @DisplayName to give more information about what the test is doing.

The assertEquals is the key difference from the old way to this way. Instead of printing expected and received, we call the already written method assertEquals(Object expected, Object actual) that checks its two arguments for equality and remembers the result.

When checking two doubles for equality, we must handle the fact that doubles can be imprecise. To rectify this, JUnit provides a method assertEquals(double expected, double actual, double tolerance) that says that expected == actual if |expected - actual| <= tolerance. For simple applications, a tolerance of 1e-6 will do, and should be used in this lab.

There is also assertTrue, assertArrayEquals, assertNull, etc. Once JUnit runs all your tests, Eclipse will pop-up a dialog on the left that shows how many tests passed. If any tests failed, you can click on them and it will explain why.

Make JUnit tests for the remaining classes and methods you have written.

Minimal Testing Required

We will add some additional test cases to test most of the methods you have written for BankAccount, CheckingAcount, and SavingAccount. See testBankAccDeposit() and testCheckingAccWithdraw() for some concrete examples. 

Inside the the initialize() method of your junit tester:

Instantiate accounts to an empty ArrayList. Then add some objects, so that accounts is holding 2 BankAccounts, 2 SavingsAccounts, and 2 CheckingsAccounts with varied values to the accounts list in a mixed-up order so that no two adjacent elements in the list are the same class.

The cool part of inheritance (subclassing) is that anywhere an instance of the parent class is expected, an instance of the child class can be given. This means our list of BankAccounts can hold BankAccounts or any of its current or future child classes.

Next, in the test method called dynamicDispatchPrinting(), print out the accounts by sending it to the System.out.println method. Remember, Java will call toString on it, which will in turn call toString on each BankAccount object. Don't forget the @Test above the method you are writing here.

From the output, we observe that each class's toString is called, and not just the `BankAccount` toString on each. This is dynamic dispatching in action - what makes inheritance powerful. Even though the static (written) type of each element in accounts is BankAccount, the dynamic (at-runtime) type of each object varies based on the order you added objects. When the toString is invoked, Java examines the dynamic type of object and calls the toString of that (sub)class. Add this block of code to dynamicDispatchPrinting() make things even more explicit, after the printout of accounts:

 

for(BankAccount b : accounts){
            if(b instanceof SavingsAccount){
                System.out.println("SavingsAccount: ");
            }
            else if(b instanceof CheckingAccount){
                System.out.println("CheckingAccount: ");
            }
            //note that we do this as an else block
            //since SavingsAccount and CheckingAccounts are also
            //considered to be instances of BankAccount
            //since they are subclasses of BankAccount.
            else{
                System.out.println("BankAccount: ");
            }
            System.out.println(b);
            
        }
 

Look for the TODO in the BankTester. You will see seven empty tests for you to complete.

 

testSavingsAccDeposit() deposits money into a SavingsAccount object. It should be similar to the provided testBankAccDeposit() method, but be sure to account for the interest rate when you calculate the expected value for the assertEquals.

 

testExceedingCheckingWithdraw(), which withdraws money from a CheckingAccount object, where the number of withdraws exceeds the CheckingAccount's withdraw limit. You can accomplish this using a for loop which is greater than its set Withdraw limit. The method will be similar to the provided testCheckingAccWithdraw()  method. Make sure that you are withdrawing amount that does not zero out the CheckingAccount before it has reached its withdrawLimit, so you can see that the account has been cut off from writing excessive checks. Have two assertions in this test, one to ensure the balance is correct, and one to ensure the withdrawCount is correct.

 

OPTIONAL: If you are feeling ambitious, try to use an assertAll when doing multiple assertions in a single test method (such as the one above). Details on this are in the JUnit link provided above. Here, use of the assertAll is optional, not required. The main difference is that with regular assertEquals, if one fails then the rest of the assertEquals don't happen. assertAll will run all the assertEquals and report back on the result of all the assertions, even if some of them raised an AssertionError. 

 

Complete the two tests dealing with withdraws from a BankAccount. One handles the case where amt <= balance, and the other handles the case where amt > balance. Have two assertions in each test, one to ensure the balance after the withdraw is correct, and one to ensure the returned amount withdrawn is also correct. Again, use assertAll if you wish here. 

 

Complete the three tests dealing with the toString() of each Account we have created. Start by constructing an object, then assertEquals between two strings, the expected and the string you get from calling toString on the object. 

 

You may add additional tests if you wish, but that is not required. Some other cases to consider would be the cases where our written methods throw IllegalArgumentExceptions for instance.

 

Dynamic Dispatching with Object Class


We can take the generalization a bit further by making an ArrayList of Objects called, objects, which is at the top of the junit tester. Since all classes and types have the Object class as their root type, anything can go in this array: Objects, ints, arrays, any of the BankAccounts, booleans, other arraylists, BankTesters, etc. Add 8 elements to the objects array, of various types, inside the initialize() method. The more creative the better. Print the objects array in the test method dynamicDispatchPrinting() and observe how each class implements its `toString` method.

This generalization is a bit too far for normal use cases. The whole purpose of types is to restrict the values that data can take on to make them more reasonable to operate on. We often want to be as general as we can, but no further. Walking this line comes with practice. If we want a list of bank accounts, we generalize to the base BankAccount class, which allows the two subclasses as well, but nothing else. We would not want the list to hold Object`s, which would mean things like String`s and arrays could be thrown in and unnecessarily complicate things.
