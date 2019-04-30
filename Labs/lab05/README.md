# lab05

Practice in lab exam

# Given instructions

This lab is just a practice in-lab exam, it will be graded as a lab under the lab category.

This lab will serve as practice for next week's in-lab programming test. In next week's test, you must use the lab machines and may not use the Internet nor eclipse, only a text-editor and the command-line. You are strongly encouraged to try to complete this lab under such an environment, but of course you don't have to this week.
The format, and difficulty will be relatively similar to that of this week's lab. Keep in mind that next week's exam is in-lab, meaning you only have the 85 minutes to start and finish the exam.

All classes below go into the lab05 package. Points deducted otherwise.

Submitting non-compiling code will be heavily penalized as we are unable to run (test) code that doesn't compile. If you're unable to get a particular piece of code to compile, comment it out such that your program compiles. Implement the classes and methods as is, do not change their names, or change the function signatures. Do not add any methods not asked for.

A Tester is provided to you at the bottom of the directions for you to run your attempts at. Be aware though that the tests are basic; passing all the tests does not imply a 100% grade. There are cases the Tester does not test that you are required to fulfill. Therefore, you are encouraged to add your own tests to the Tester to better test your solutions.

 

Here is a link to the github repository.

Question 1
Create a class Division with one private field: a List<Double> named list.
Initialize list to an empty ArrayList in the declaration
Create a constructor that takes in double[] array as a parameter and adds each double in array to list
if array is null or empty, throw an IllegalArgumentException with a message "need to enter an array with at least one double"
Create a method public void removeZeroes() which removes all zeroes from list. Think about the correct way to do this, remembering that removing from a data structure which dynamically changes in size can be tricky. 
Create a method public void divide(int divisor)
Replaces each entry in list with that entry divided by divisor
if divisor is zero, throw an IllegalArgumentException with a message "cannot divide by zero"
For example, if list is [1,2,3,4,5,6,7,8,9] and divisor is 2, after the call list will be [0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0, 4.5]
Override the toString method that returns list.toString();

Question 2
Create a class FunWithStrings with no fields
Implement the method public static void swapMaxes(List<String> list1, List<String> list2)
if either list1 or list2 are null or empty, or a list contains only null elements, throw an IllegalArgumentException saying "cannot swap maxes of empty lists, null lists, or lists with all null elements"
you can assume that each non-null String in list1 and list2 will all have different lengths
if a String contained in either ArrayList is null, ignore it and continue searching for the longest String
find the longest String in list1 (need a way to store the String and the index it is at)
find the longest String in list2 (need a way to store the String and the index it is at)
swap the longest Strings between the two arrayLists
For Example, given ["to", "cellphone", "truck", "fire"] and ["delicious", "copper", "blue", "red"], after this method is called list1 will be ["to", "delicious", "truck", "fire"] and list2 will be ["cellphone", "copper", "blue", "red"]

Question 3
Create a class Zipper with no fields.
Implement the method public static int[] zip(int[] arr1, int[] arr2)
If either arr1 or arr2 is null, or they do not have the same length, throw an IllegalArgumentException with a message "bad input"
This method should return an array that alternates between the elements of arr1 and arr2 in the order they appear in their arrays.
For example, given {1, 2, 3, 4} and {5, 6, 7, 8}, {1, 5, 2, 6, 3, 7, 4, 8} should be returned
Return an empty array if empty arrays are given.

