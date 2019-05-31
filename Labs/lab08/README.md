# lab08

Introduction to Recursion

# Given Instructions

Create a class Recursion which will hold a bunch of static recursive methods to practice recursion.

Add a private static final double DELTA field to this class and initialize it to 1e-6.

Create a method public static int factorial(int n) which we will implement recursively. Recall the factorial of a number is the product of that number and the factorial of the difference of that number and 1. The factorial of 0 is 1 and the factorial of 1 is 1. If either of the base cases apply, return the corresponding int, otherwise we must recurse by calling the factorial method with n-1 and then returning the product of n and this return value.

Sometimes when working with recursion, we need to know where we are in the recursive call chain and as such need more than one parameter. When the overall function only requires one parameter but our implementation requries two, it is useful to create a helper function with two parameters that our function with one parameter can call.

Create a method public static double squareRoot(double n) and a helper method private static double squareRootHelper(double n, double approx).

One way to compute the square root of a number is to make a guess of the square root and continuously refine that guess until it is "close enough". The implementation of squareRoot is simple, it just calls its helper method, passing in its parameter and some initial guess of your choosing. The real logic goes in squareRootHelper. One base case is that we're computing the square root of 0, which is 0. The other base case is that our current guess for the square root is close enough to the original number. This is the case if the absolute difference between approx squared and n is less than 1e-6. Recall that we can get the absolute value of something with the function Math.abs, no imports necessary. Otherwise, we must recurse with the same number but with a better approximation. This better approximation is computed as (approx + n/approx) / 2.

So far we've seen recursion for recursive mathematical sequences but recursion is also a natural choice for recursive data structures. A recursive data structure is one that is defined in terms of smaller instances of itself. Lists and arrays can be defined recursively.

A list of ints can be defined as either the empty list or an int followed by a list. The list is defined in terms of another, smaller list, which in turn is defined in terms of another, smaller list, ..., which in turn is defined by the empty list. We could write the list [1, 2, 3, 4] as [1 : [2 : [3 : [4 : []]]]] where ':' takes an int and an int list and returns an int list with the int as the first element, followed by the elements of the original int list. Similarly for arrays.

Create a method public static int sum(List<Integer> nums) and a helper method private static int sumHelper(List<Integer> nums, int index) which will recursively sum the elements of nums. Again sum will simply call sumHelper with some initial value and sumHelper will do the heavy lifting. The index in sumHelper is needed to track the position in the list this method should examine. sum should return the result of calling sumHelper with the same number and an initial index of 0 (the first element). The base case for sumHelper happens when we are at the end of the list. This case should cover the case where nums is empty. If we are not at the end of the list, then we must recurse by returning the sum of the int at index index and the result of calling sumHelper on the same list but with the index plus 1.

Create a method public static int sum(int[] nums) and a helper method private static int sumHelper(int[] nums, int index) which do the same thing but with arrays, not arraylists. Note that it is possible to have more than one method/constructor with the same name as long as they can be distinguised. sum(int[]) can be distinguished from sum(ArrayList<Integer>) because their first parameters have different types. Similary for both sumHelpers.

Another mathematical recursive sequence we can implement is the binomial coefficient. Create a method public static int binomialCoefficient(int n, int k) which will represent n choose k or (n C k). (n C k) is defined recursively as (n-1 C k-1) + (n-1 C k) where (n C 0) is 1. Also, recall the identity that (n C k) == (n C n-k). To exploit this, we have another base case when k is more than half of n. In this case, we return (n C n-k).

JUnit Tester
Make JUnit tests for

factorial
test both base cases and a non-base case (will need 3 test methods)
squareRoot
test either 0 or 1 and a perfect square (will need 2 test methods)
sum(ArrayList)
test one arraylist of 3 non-null ints
sum(int[])
test one array of 3 ints
binomialCoefficient
test one where k < n/2 and one where k > n/2, where n > 2 in both. (2 methods)
