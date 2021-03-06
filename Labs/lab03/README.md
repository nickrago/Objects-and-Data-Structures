# lab03

Introduction to ArrayLists

# Given Instructions

Introduction to a new data structure: ArrayLists

Arrays give us a nice way to bundle like items together and operate on it as a whole. We are however sometimes limited by the fact that arrays are of fixed length. ArrayLists provide similar functionality but grow dynamically as we need them to.
The below snippet shows how to make a new ArrayList.


import java.util.ArrayList; // need this in any class that uses ArrayLists
import java.util.List; //also need this one
// ...
List<T> list = new ArrayList<>(); // list that will grow to hold elements of type T
Notice angle brackets instead of square brackets. The type of each element goes in between the angle brackets. Like arrays, each element in an ArrayList must be the same type. Notice we also didn't give the list any size, that's taken care of internally. We are also setting List equal to an instance of an ArrayList here. This is possible because ArrayList is a subtype of the interface List. You will learn more about sub-classes and interfaces as the course continues on.


Unlike arrays, which can hold Objects like Account and primitive (simple) types like int, boolean, Lists can only hold Objects. So List<int>won't compile, we need to use its Object equivalent Integer. There is also Double, Character, Boolean, and so on.

What if we know some initial values we want the ArrayList to have up front? In other words, what is the Arraylist equivalent of the array way?


import java.util.ArrayList;
import java.util.List;
import java.util.Arrays; // need this too
// ...
//declaration of an array holding integers with some initial values
int[] my_int_array = { 1, 2, 3 }; 
//declaration of an ArrayList holding integers with some initial values
List<Integer> my_int_list = new ArrayList<>(Arrays.asList(1, 2, 3)); 
Suppose we have an array called array with length N and suppose we have an ArrayList called list. Assume both hold elements of type T.
Here are some comparisons between how we can do certain things on both arrays and ArrayLists:


Concept	Array	ArrayList
Empty creation	T[] array = new T[N];	
List<T> list = new ArrayList<>();
NOTE new ArrayList<>(N); does NOT help
-- list will still be empty but the "backing array"
will have length N instead of the default 10
Value creation	T[] array = { t0, t1, t2, ... }	List<T> list = new ArrayList<>(Arrays.asList(t0, t1, t2, ...));
get i-th element	array[i]	list.get(i);
set i-th element to v	array[i] = v;	list.set(i, v)
get number of elements	array.length	list.size();
add element e to the end	N/A	list.add(e);
add element e to i-th index	N/A	list.add(i, e)
remove i-th element	N/A	list.remove(i);
print elements	System.out.println(Arrays.toString(array));	System.out.println(list);
index error	ArrayOutOfBoundsException	IndexOutOfBoundsException
 

Let's highlight the difference summarized above. First, notice that to get how many elements are in an array, we use array.length. However, with an ArrayList there is no length field, we instead call the method size() on our instance of an ArrayList, ie, list.size().

You should note that to do things with an instance of the ArrayList class, we call a bunch of methods on the instance.

We have a get(int index) method, which allows us to grab an element in the arrayList at a specified index.
We have a set(int index, T element) method, which allows us to change the value stored at some specified index, to a new value we specify.
We have an add(T element) method and add(int index, T element), which allows us to add an extra value to the ArrayList, increasing the ArrayList's overall size by 1 as a result.
If we pass in only 1 argument, then we treat that argument as an element we want to add to the end of the ArrayList
If we pass in 2 arguments, then we treat the first argument as an index, and the second as the element we are trying to add.
Note that the above is a concrete example of method overloading, specifically with the add() method.
We have a remove(int index) method, which allows us to remove the element located at the specified index of the ArrayList, decreasing the ArrayList's overall size by 1 as a result.
There are many other methods that we can call on an ArrayList, but we will focus on the 5 mentioned methods, get(), set(), add(), remove(), and size().

Note that there is no add and remove equivalent operation for arrays, because they have fixed length. 


A Pitfall to Avoid Early On

One more thing that is worth mentioning. Early on, students try to write code such as the following:


List<Integer> myArrList = new ArrayList<>();
myArrList.set(0, 3); //trying to set first element of the ArrayList to the integer 3 here. This is an error, throws IndexOutOfBoundsException.
Do you see why this is an error? Recall that when myArrList is declared as above, it starts out as an empty ArrayList. Since the ArrayList is empty, there is no index 0 yet! We cannot use the set method in this fashion. To add 3 to the ArrayList, simply use the add() method. Below is some example code that hopefully clears up some lingering questions you may have about how add() and remove() work:


List<Integer> myArrList = new ArrayList<>(); //size is zero initially here. []
myArrList.add(3); // correctly adds the integer 3 to the myArrList, automatically at index 0. size is now 1. [3]
myArrList.add(4); //adds integer 4 at end of myArrList. size is now 2. [3, 4]
myArrList.add(5); // adds integer 5 at end of myArrList. size is now 3. [3,4,5]
myArrList.add(1,2); //adds integer 2 at index 1, shifting over all values to the right of that index. size is now 4. [3,2,4,5]
myArrList.set(3, 8); //sets integer at index 3 to 8. size is still 4. [3,2,4,8]
myArrList.add(6); //adds integer 6 at end of myArrList. size is now 5. [3,2,4,8,6]
myArrList.remove(2); //removes integer at index 2, auto shifts to close gap. size is now 4. [3,2,8,6] 
 

Immutable Lists
 

There is also a way to make something called an Immutable List. The syntax looks like this:

 

import java.util.List;
//declaration of an immutable List holding integers with some initial values
List<Integer> my_int_list = List.of(1, 2, 3);
 

An immutable list can not be altered, which means the set(), add(), and remove() methods will not work. In fact, if you try to call these on an immutable list, you will have a UnsupportedOperationException occur at runtime. We will discuss Exceptions in detail in a future lab.

 

Let's Get Coding
Now that you have a introduction to ArrayLists, let's write some code. Here is the link to accept the assignment on github.  Make sure to cd into the directory once you have cloned it before you start working. All the starter code will compile except for ClassRoomTester, since you have to make ClassRoom.java from scratch. You may only use the 5 methods get(), set(), add(), remove(), and size() on your ArrayLists for this lab.


Open up the provided class called VectorMath. Note the imports for Optional, ArrayList and List have been included at the top of the file.


You will need to complete the static methods provided. We have also included a test for you, VectorTester.

 

Notice that vect1 in VectorTester is an immutable List, which means we cannot actually alter vect1. You will see we account for this in a try catch block of VectorTester. Essentially, we try to do something that we know will cause a runtime exception, and then catch that exception, printing out some information explaining what happened. Catching the error allows the program to keep running, without crashing.

 

Calculating the Magnitude of a Vector

 

magnitude() returns the length of a given vector in an Optional<Double>.

If the vector is null, return an empty Optional (Optional.empty()).
If the vector is empty, return a length of 0 in the Optional (Recall you can use Optional.of(0.0) to return an Optional holding 0.0).
Otherwise, the length is calculated by first adding up the square of each Double in the vector, and then taking the square root of that result.
You can use Math.sqrt() to take the square root here, and multiply a number by itself to square it.
For example, the vector <3, 4> would have a magnitude of sqrt(3^2 + 4^2) = sqrt(9 + 16) = sqrt(25) = 5.
 

 

Multiplying a Vector by some scalar value

 

scalarProduct() takes each Double in vect and multiplies them by the value scale.

Note that here, we are not returning anything, the method is actually altering the vector vect that gets passed in. Our intent is that you use the set() method here.
If vect is empty or null, then vect remains the same.
For example, if we pass in vect = <1, 2> and scale = -3, then vect = <-3, -6> after scalarProduct() is called.
 

Calculating the dot product between two given vectors 

 

dotProduct() returns a Optional<Double>, which is calculated by multiplying component wise, and adding the products together.

If either vector is null, return an empty Optional.
If either vector is empty, we define the dotProduct to be zero.
 

In 3 dimensions, a vector is made up of an x component, y component, and z component. <x,y,z>
Multiplying two vector's entries component wise means we multiply the x components together, then the y components together, and finally the z components together.
This component wise process is the same for vectors of other dimensions.
Note that vect1 and vect2 could have different lengths. In such cases, you could imagine appending zeroes to the smaller dimensional vector.
For example, if vect1 = <1,2> and vect2 = <3,4,5>, then we can view vect1 as <1, 2, 0>. The dot product would then be: 1*3 + 2*4 + 0*5 = 3 + 8 + 0 = 11. 

Hint: Note that although you could imagine appending zeros to the smaller vector, you should not do this in your code as you will be altering the vectors passed in. We can see from the above example that their contribution will be zero to the dot product overall, so we should just add up all the products up to the smallest dimension here. You can use a slightly more interesting terminating condition in your for loop: for(int i = 0; i < vect1.size() && i < vect2.size(); i++){...}. Alternatively, you could use Math.min(a, b), which returns the minimum between two ints a and b. 
 

Deciding if two vectors are Orthogonal to one another


isOrthogonal() returns true if the dotProduct between vect1 and vect2 is zero, and false otherwise.

Note that orthogonal means the vectors are perpendicular to one another, forming a 90 degree angle.
If the Optional returned by dotProduct is empty, isOrthogonal() should return false.
Recall you can check if an Optional is empty by using opt.isPresent() where opt refers to an Optional.
isPresent() returns true if opt holds a value, and false if opt is empty.
If a value is present, you can get the value by using opt.get()
 

Performing Vector Addition between two given vectors 

 

vectorAddition() returns an Optional holding a new vector, which is found by adding vect1 and vect2 together, component wise.

If either vect1 or vect2 are null, return an empty Optional.
If either vect1 or vect2 is empty, then you return an Optional containing a new vector which holds all the elements of the other vector. 
Note that vect1 and vect2 could have different lengths. Again, you could imagine appending zeroes to the smaller dimensional vector.
For example, if vect1 = <1,2> and vect2 = <3,4,5>, then we can view vect1 as <1, 2, 0>. The returned vector would then be: <1 + 3, 2 + 4, 0 + 5> = <4, 6, 5>. 

Hint: Note that although you could imagine appending zeros to the smaller vector, we should not do this as it would alter the vectors passed in. Another way to think of it is that we add the values component wise up to the smaller dimension, and then append the values that are left over in the larger vector. 
 

Simulating a ClassRoom Roster
Take a look at Student.java, which we have provided for you, taking note of the getters and the toString() method.

 

Next, make a class called ClassRoom.

Make sure to import List and ArrayList as above, and its in package lab03.
It has one private field, List<Student> roster, which is initialized to an empty ArrayList.
Do NOT add a constructor for ClassRoom. By default, if we do not specify one, there will be a constructor which takes no arguments available to create a ClassRoom object.
Make a getter method, getRoster for the roster field.
Make a method called addStudent, which takes a Student s as a parameter. The method appends s to the end of roster.
 

Write a method called dropStudent, which takes an int id as a parameter. The method searches for a Student in roster with the specified id, and removes that Student from roster. If no student has the id specified, then the roster remains unchanged. Note we are assuming students will have unique id's here for simplicity.
 

Override the toString() method, see our example in Student, and have it return roster.toString();
 

Write a method sortById(), which will rearrange the Students in roster based on their id field, in increasing order. Here is an example of implementing bubble sort. Do not just blindly copy and paste this code. Read through it yourself and see if you can understand what is going on, then watch the gif in the bubble sort link provided here. Try to use this provided algorithm in a similar fashion for sortByID().
 

public void bubbleSort(int[] arr){
	for(int i = 0; i < arr.length; i++){
		for(int j = 1; j < (arr.length-i); j++){
			if(arr[j-1] > arr[j]){
				//swap elements
 				int temp = arr[j-1];
 				arr[j-1] = arr[j];
			 	arr[j] = temp;
 			}
		 }
	}
}
 

Try and run ClassRoomTester and feel free to add more tests of your own.
