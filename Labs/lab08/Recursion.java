package lab08;

import java.util.List;

public class Recursion {
	private static final double DELTA = 1e-6;
	
	public static int factorial(int n) {
		if(n<0) throw new IllegalArgumentException("input: " + n + ", n cannot be a negative number");
		if(n == 0) return 1; 
		if(n == 1) return 1;
	    return n*factorial(n-1);
	}
	
	public static double squareRoot(double n) {
		return squareRootHelper(n, n/2);
	}
	
	private static double squareRootHelper(double n, double approx) {
		if(n == 0) return 0;
		if(Math.abs(approx * approx - n) < DELTA) {
			return approx;
		}
		else {
			double guess = (approx + n/approx) / 2;
			return squareRootHelper(n, guess);
		}
	}
	
	public static int sum(List<Integer> nums) {
		return sumHelper(nums, 0);
	}
	
	private static int sumHelper(List<Integer> nums, int index) {
		if(nums == null || nums.size() == 0) return 0;
		if(index < (nums.size() - 1)) {
			return (nums.get(index) + sumHelper(nums,index+1)); 
		}
		else {
			return nums.get(nums.size() - 1);
		}
	}
	
	public static int sum(int[] nums) {
		return sumHelper(nums, 0);
	}
	
	private static int sumHelper(int[] nums, int index) {
		if(nums == null || nums.length == 0) return 0;
		if(index < (nums.length - 1)) {
			return (nums[index] + sumHelper(nums,index+1)); 
		}
		else {
			return nums[nums.length - 1];
		}
	}
	
	public static int binomialCoefficient(int n, int k) {
		if(k == 0) return 1;
		if(k>(n/2)) return binomialCoefficient(n, n-k);
		return(binomialCoefficient(n-1, k-1) + binomialCoefficient(n-1,k));
	}
}
