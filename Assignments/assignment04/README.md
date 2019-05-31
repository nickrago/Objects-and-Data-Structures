# assignment04
Assignment 4

# Given Instructions

We will understand in the future how roster will store the students we add in order of their id's so we have no need to use sortId()--delete the method sortId().

Keep the method public List<Student> getRoster() but now it returns new ArrayList<>(roster). We are using the constructor in ArrayList that takes a collection of elements as an argument and puts all the elements in the collection into the list (in order).

Keep the method public void addStudent(Student s). No change is needed. The special thing about the TreeSet is that the new element will go into the correct position automatically to keep the oder of the id's
 
Keep the method public boolean isRegistered(int id) but you cannot use a for loop with an index i, it must be an enhanced loop to work with a TreeSet: for (var stu : roster) will go through all the Students in the roster.

Rewrite the method public List<Student> alsoRegisteredIn(ClassRoom... others) to take advantage of the fact that TreeSet can do the intersection of sets for you. Let temp be a copy of roster using var temp = new TreeSet<Student>(roster); (all the references to elements in roster get copied to temp). Then for each cRoom in others, call temp.retainAll(cRoom.roster); You can read about retainAll here. At the end return new ArrayList<>(temp).

In this case return the complete ArrayList copy of roster if others is null or empty.
 
Skip the method public static List<Student> registeredInAll(ClassRoom... others) since it was confusing and it can easily be derived from the method above.
 
Keep the method public static List<Student> registeredInOne(ClassRoom... others). Again take advantage of the fact that sets only store one copy of any element. Make a an empty set temp using var temp = new TreeSet<Student>();  for every cRoom in others, call temp.addAll(cRoom.roster). Return the ArrayList made form temp as we did above.

In this case return an empty ArrayList if others is null or empty.
 
Let's use an Iterator to implement public void dropStudent(int id) cleanly: import java.util.Iterator. Make the Iterator using var iter = roster.iterator(); since TreeSets can provide an Iterator. Then, in the loop while(iter.hasNext()) simply test if(iter.next().getId() == id) and call iter.remove() in that if statement.
