package assignment02;

public class LoanUtility{

  public static void putInDescendingOrder(LoanPackage[] loans){
    int j;
    for(int i = 0; i<loans.length-1; i++){
      j = indexOfFirstLargestAmountDue(i, loans);
      if(!(i == j)) LoanPackage.exchangeFields(loans[i], loans[j]);
    }
  }

  public static int indexOfFirstLargestAmountDue(int start, LoanPackage[] loans){
    int index = start;
    for(int i = index; i<loans.length; i++){
      if(loans[index].compareTo(loans[i])< 0) index = i;
    }
    return index;
  }

}
