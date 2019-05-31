# lab10

Introduction to Streams

# Given Instructions

Implement the method public static List<String> grabBingoNums(String letter)

The method will return a List of the bingoNumber Strings that start with letter, in sorted order. The sort should be by natural order, which you can do by just calling sorted() on a stream. Also, make sure that all the bingoNumbers in the returned list start with an uppercase letter. You may NOT use any if statements or for loops in any of the methods being implemented for this lab, only steam operations and chaining.

Implement the method public static List<Integer> extractNums() which returns a the List of the bingo numbers, but with the front letter removed and converted to an Integer. 

Implement the method public static int sumLists(List<List<Integer>> lists), which will add up all the values found in each list and return the result. 

Implement the method public static boolean isPalindrome(String str), that returns whether str is the same forwards as it is spelled backwards.

Implement the method public static void printPalindromes(List<String> list) that filters out the words which are palindromes, and then prints them out. 
