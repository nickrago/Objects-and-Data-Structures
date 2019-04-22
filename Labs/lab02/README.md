# lab02

Introduction to arrays and for loops

# Given Instructions

A word about Eclipse
We will be learning and using the Eclipse IDE for Java development later in the semester. You are of course allowed to use it now as some of you already know it, however there will be in-lab exams, the first of which will require the unassisted use of the command line and forbid Eclipse. If you are unfamiliar with Eclipse, its probably best to wait to use it.

 

Refresher
You will probably want to cd into your cs140/labs. 

 

Here is the github link for lab02, go ahead and accept it now.

 

Then hit the green clone or download button, copying the URL. 

 

Back in the terminal, run the command:

 

git clone URL
 

Recall that it is javac -d . *.java to compile and java lab02.X to execute, where X is the name of the class whose main method you wish to run. 

All classes should be in the package lab02

You can create new files via the command line by running gedit fileName.java& where fileName is the name of the class.

 

A simple class


Create a class, Book which will model a printed book.

 

Give the class two private instance variables, title of String type and numPages of int type. 

Copy/paste this constructor as the Book constructor and fill in the missing two lines such that aTitle is assigned to title and similarly for numPages.

public Book (String aTitle, int aNumPages) {

}

Provide getter methods for title and numPages. Remember the method return type must match the variable type and the method name comes from prepending the word 'get' to the capitalized variable name. 

Compile the Book class with javac -d . *.java to make sure its correct before moving on.


Introduction to Arrays
When we want to hold an arbitrary number of things together, Java offers the array data structure. Arrays are fixed-length meaning once you pick its length, it cannot change. They can also only hold things of the same type. The following code chunks are for demo only, you don't need to copy them anywhere.


To declare an array of 3 integers: 


int[] someInts = new int[3]; // holds {0, 0, 0}
This only declares the space for 3 ints, it doesn't initialize any of the slots so they default to 0. 

If you know the elements you want your array to have 


int[] myInts = {1, 2, 3};
you just list them in between curly braces as above. 

Array elements can be retrieved or set using square braces ([]). 


System.out.println(myInts[0]); // prints 1
myInts[1] = 5;
myInts[2] = 1;
System.out.println(myInts[2]); // prints 1
Notice that array indices, like most other programming languages, start at 0 and go up to one less than the array's length. In Java, array indices must be positive. 

To retrieve an array's length (which can never change), use length (without parentheses). So, to print the last element of an array of any length: 

 

System.out.println(unknownArray[unknownArray.length-1])
Remember the elements of an array must all be the same type. It would be illegal to add a double or a String to myInts.

The for loop is a natural way to visit each element of an array in linear order. 

for (int i = 0; i < myInts.length; i++) {
    System.out.println(myInts[i]); // print ith element of myInts
}
 

More about arrays can be found here.


A library of Books


Create a class Library with a main method. Recall the main method is written

public static void main(String[] args) {

}
 

In the main method, declare an array named library to hold three (3) Books. Set each book in the array to a new Book with a title and number of pages you choose. Use a for loop to print out only the title of each book. 

There is another way to write a for loop, called the enhanced for loop. For example, if we wanted to loop through myInts:

// format is type of single element in array, dummy variable name, name of array
for (int currentElement : myInts) {
    System.out.println(currentElement);
}

After you print the book titles using the regular for loop, print out the number of pages of each book using the enhanced for loop. 

Write the method public static int numPagesInLibrary(Book[] books) inside the Library class. The method takes in an array of books and should return the total number of pages in all books. Use either for loop style. 
Once that method is written, jump back to the main method to test it. First print out the number you expect would be returned by the method based on how you created your books. Then print the result of calling numPagesInLibrary when library is passed in.


Write the method public static int mostPages(Book[] books) inside the Library class. The method takes in an array of books and should return the maximum number of pages among all books in books. In the main method, print out the number you expect (i.e. the number of pages of the longest book you created). Then, again in the main method, print out the result of calling mostPages when library is passed in. 

Compile and run the Library class. Make sure the output matches with what is expected. Recall the command to run is java lab02.Library.

 

Push to GitHub and Submit Commit Hash to MyCourses

When you are finished, make sure you are in your git directory. You can then add and commit your work by using: 

 

git add -A
git commit -m "completed lab02" 
git push
 

Remember that we will only grade your submission that corresponds to the commit hash you give us in MyCourses. To get your latest commit hash, run:

 

git rev-parse HEAD
 

Submit the corresponding commit hash to MyCourses, under the lab02 submission link.
