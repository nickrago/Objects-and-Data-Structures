# assignment02
Assignment 2
Due Date Friday February 8, 11:59pm
Submission location for assignment02
Note that LoanPackage is a class that will be in the package assignment02

# Given Instructions

Question 1. Copy the Loan and your copy of Loanee from Lab01 (assuming you completed it). Copy the LoanSimulation class but change all the code in the body of the main method as follows. Make an array of Loanee of length 3 and in a for loop (see Lab02)  assign each element of the Loanee array that is not the last element of the array to a new Loanee with money 100. Assign the last element to be  a new Loanee with money 110. Hint: you can make the distinction by using an if and else statement within the for loop. The elements of this array will correspond to the 3 person objects in the original LoanSimulation. Next make an array of int amt containing 100, 100, and 100, also make an array of double ir containing 0.0, 0.1, and 0.1 and an array of int yrs containing 10, 1, and 1. These are the arguments passed to canPayLoan used in the original LoanSimulation.  Make an array of boolean canpay of length 3. In a for loop set canpay[i] to Loanee[i].canPayLoan(amt[i], ir[i], yrs[i]). Import java.util.Arrays and then use System.out.println to print Arrays.toString(canpay).

Question 2.Copy the class Loan to LoanPackage.java. Change the class name and the constructor name to LoanPackage. Add the private field int numYears and a private field double finalAmountDue. Add the 3rd parameter int years to the constructor and set numYears to years in the constructor, then, in the constructor calculate the value of finalAmountDue using the code that is in getAmountDue(). Change the code in getAmountDue() to simply return finalAmountDue and take out the parameter years. Also add the getter method getNumYears for the field numYears.

Question 3. Write a tester Question3.java with a main method that tests the static methods LoanPackage.exchangeFields and LoanUtility.indexOfFirstLargestAmountDue, and LoanUtility.putInDescendingOrder

Question 4. Make a class Loanee1 which is a copy of Loanee but has two extra private fields String name and LoanPackage loanPackage. Change the constructor so that the second parameter is the name of the Loanee and is used to set the value of the field name. Provide the getter method for the field name.Provide a method public void addMoney(int amount) that adds amount to the field money. Add a method public void setLoanPackage(int amount, double ir, int years), which sets loanPackage to new LoanPackage(amount, ir, years). Also add a method public double getLoanAmount() that returns loanPackage.getAmountDue().
