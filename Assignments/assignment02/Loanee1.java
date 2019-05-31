package assignment02;

public class Loanee1{
  private int money;
  private String name;
  private LoanPackage loanPackage;

  public Loanee1(int money, String name){
    this.money = money;
    this.name = name;
  }

  public int getMoney(){
    return money;
  }

  public String getName(){
    return name;
  }

  public void addMoney(int amount){
    money += amount;
  }

  public void setLoanPackage(int amount, double ir, int years){
    loanPackage = new LoanPackage(amount, ir, years);
  }

  public double getLoanAmount(){
    return loanPackage.getAmountDue();
  }

  public boolean canPayLoan(double amt, double ir, int years) {
    Loan loan = new Loan(amt, ir);
  	double amountDue = loan.getAmountDue(years);
  	int money = getMoney();

    if(money >= amountDue) return true;
  	return false;

  }

}
