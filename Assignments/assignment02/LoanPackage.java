package assignment02;

public class LoanPackage {
  private double amount;
  private double interestRate;
  private int numYears;
  private double finalAmountDue;

  public LoanPackage(double amt, double ir, int years){
    this.amount = amt;
    this.interestRate = ir;
    this.numYears = years;
    this.finalAmountDue = getAmount() * years;
  }

  public double getAmount(){
    return amount;
  }

  public double getInterestRate(){
    return interestRate;
  }

  public double getAmountDue() {
    return finalAmountDue;
  }

  public int getNumYears(){
    return numYears;
  }

  public int compareTo(LoanPackage pkg){
    return Double.compare(finalAmountDue, pkg.finalAmountDue);
  }

  public static void exchangeFields(LoanPackage pkg1, LoanPackage pkg2){
    pkg1.amount = pkg1.amount + pkg2.amount;
    pkg2.amount = pkg1.amount - pkg2.amount;
    pkg1.amount = pkg1.amount - pkg2.amount;

    pkg1.interestRate = pkg1.interestRate + pkg2.interestRate;
    pkg2.interestRate = pkg1.interestRate - pkg2.interestRate;
    pkg1.interestRate = pkg1.interestRate - pkg2.interestRate;

    pkg1.numYears = pkg1.numYears + pkg2.numYears;
    pkg2.numYears = pkg1.numYears - pkg2.numYears;
    pkg1.numYears = pkg1.numYears - pkg2.numYears;

    pkg1.finalAmountDue = pkg1.finalAmountDue + pkg2.finalAmountDue;
    pkg2.finalAmountDue = pkg1.finalAmountDue - pkg2.finalAmountDue;
    pkg1.finalAmountDue = pkg1.finalAmountDue - pkg2.finalAmountDue;
  }
}
