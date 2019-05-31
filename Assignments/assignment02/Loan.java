package assignment02;

public class Loan {
  private double amount;
  private double interestRate;

  public Loan(double amt, double ir){
    this.amount = amt;
    this.interestRate = ir;
  }

  public double getAmount(){
    return amount;
  }

  public double getInterestRate(){
    return interestRate;
  }

  public double getAmountDue(int years) {
      double amt = amount;
      for (int i = 0; i < years; i++) {
          amt += amt * interestRate;
      }
      return amt;
  }
}
