package assignment02;

public class Loanee{

  private int money;

  public Loanee(int money){
    this.money = money;
  }

  public int getMoney(){
    return money;
  }

  public boolean canPayLoan(double amt, double ir, int years) {
    Loan loan = new Loan(amt, ir);
  	double amountDue = loan.getAmountDue(years);
  	int money = getMoney();

    if(money >= amountDue) return true;
  	return false;

  }

}
