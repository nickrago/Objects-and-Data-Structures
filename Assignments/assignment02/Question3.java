package assignment02;

import java.util.Arrays;

public class Question3{
  public static void main(String[] args){
    LoanPackage test1 = new LoanPackage(100.50, 0.5, 10);
    LoanPackage test2 = new LoanPackage(200.75, 0.25, 5);

    LoanPackage.exchangeFields(test1, test2);

    System.out.println("Exchanged Amounts:\n");
    System.out.println("Package 1: " + test1.getAmount());
    System.out.println("Package 2: " + test2.getAmount());
    System.out.println("");

    System.out.println("Package 1: " + test1.getInterestRate());
    System.out.println("Package 2: " + test2.getInterestRate());
    System.out.println("");

    System.out.println("Package 1: " + test1.getNumYears());
    System.out.println("Package 2: " + test2.getNumYears());
    System.out.println("");

    System.out.println("Package 1: " + test1.getAmountDue());
    System.out.println("Package 2: " + test2.getAmountDue());
    System.out.println("\n~~~~~\n");

    LoanPackage[] loans = {test1, test2};
    System.out.println("Index of First Largest Amount Due:\n");
    System.out.println(LoanUtility.indexOfFirstLargestAmountDue(0, loans));
    System.out.println("\n~~~~~\n");

    System.out.println("Put in Descending Order:\n");
    LoanUtility.putInDescendingOrder(loans);
    System.out.println(Arrays.toString(loans));

  }
}
