package lab10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {
public static void main(String[] args){
		
		System.out.println("B bingo nums: " + grabBingoNums("B"));
		System.out.println("I bingo nums: " + grabBingoNums("I"));
		System.out.println("N bingo nums: " + grabBingoNums("N"));
		System.out.println("G bingo nums: " + grabBingoNums("G"));
		System.out.println("O bingo nums: " + grabBingoNums("O"));
		System.out.println("-------------------------------------------");
		
		System.out.println("extracted nums: " + extractNums());
		System.out.println("-------------------------------------------");
		
		List<List<Integer>> lists = new ArrayList<>();
		lists.add(extractNums());
		lists.add(new ArrayList<Integer>(Arrays.asList(1,2,3)));
		lists.add(new ArrayList<Integer>(Arrays.asList(4,5,6)));
		lists.add(new ArrayList<Integer>(Arrays.asList(7,8,9, 10)));
		System.out.println("sum: " + sumLists(lists));
		System.out.println("-------------------------------------------");
		
		System.out.println("odd count: " + countOdd(new int[]{1,2,3,4,5,6,7,8,9}));
		System.out.println("-------------------------------------------");

		List<String> words = new ArrayList<>();
		words.add("101");
		words.add("11011");
		words.add("cat");
		words.add("1000");
		words.add("12321");
		words.add("civic");
		words.add("sagas");
		words.add("dog");
		words.add("rotator");
		words.add("racecar");
		words.add("banana");
		words.add("animal");
		words.add("anna");
		
		System.out.println("palindromes: ");
		printPalindromes(words);
	}
	
	private static List<String> someBingoNumbers = Arrays.asList(
			"N40", "n36", "B12", "b6", "G49", "G53", "G60", "G50", "g64", "I26", "i17", "I29", "O71");
	
	public static List<String> grabBingoNums(String letter){
		List<String> retList = someBingoNumbers.stream()
											   .map(e->e.toUpperCase())
											   .filter(e -> e.contains(letter))
											   .sorted()
											   .collect(Collectors.toList());
		return retList;
	}
	
	
	public static List<Integer> extractNums(){
		List<Integer> retList = someBingoNumbers.stream()
												.map(e -> Integer.parseInt(e.substring(1)))
												.collect(Collectors.toList());
		return retList;
	}
	
	public static int sumLists(List<List<Integer>> lists) {
		List<Integer> integerList = lists.stream()
										 .flatMap(x -> x.stream())
										 .collect(Collectors.toList());
		return integerList.stream().reduce(0, (a,b) -> a + b);
	}
	
	public static boolean isPalindrome(String str) {
		StringBuilder sb = new StringBuilder(str);
		return (sb.toString().equals(sb.reverse().toString()));
	}
	
	public static void printPalindromes(List<String> list) {
		list.stream().filter(Streams::isPalindrome).forEach(str -> System.out.println(str));
	}
	
	public static long countOdd(int[] arr) {
		return Arrays.stream(arr).filter(e -> e%2 == 1).count();
	}
	
}
