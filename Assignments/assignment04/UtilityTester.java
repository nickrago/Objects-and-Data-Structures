package assignment04.assignment04;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UtilityTester{
  public static void main(String[] args) {
	System.out.println(Arrays.toString(Utility.concat (
			new int[] {3,6,10,11},
			new int[] {-10,6,9,10,12},
			new int[] {2,7,7,12},
			new int[] {-1,1,1,4,9,10})));

  System.out.println(Arrays.toString(Utility.merge(
      new int[] {3,6,10,11},
      new int[] {-10,6,9,10,12},
      new int[] {2,7,7,12},
      new int[] {-1,1,1,4,9,10})));
  }
}
