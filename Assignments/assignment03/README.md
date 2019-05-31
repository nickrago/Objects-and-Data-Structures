# assignment03
Assignment 3

Due date WEDNESDAY February 13, 11:59pm

We will try to get you used to doing assignments by Wednesday, so this one is not too long.

# Given Instructions

Question 1. Now add a method public static void sortById(List<Student> list), which sorts list using the same algorithm used in the other sortById. Of course, if this is the sortById you wrote for the lab, then write the one above.

Question 2. Write the method public boolean isRegistered(int id), which returns true if the Student with the given id appears in the field roster. You CANNOT use the contains method for this method. Use a loop to find if there is a Student in roster with the given id.

Question 3 . Write a method public List<Student> alsoRegisteredIn(ClassRoom... others) which returns a list of the Students in roster, who are also registered (in the rosters of) all the ClassRooms in others. NOTE others can be treated as an array, for example for(var c : others) goes through all the ClassRooms c in others.  Alternatively for(int i = 0; i < others.length; i++) and others[i] are ways to work with the variable length parameter. FOR TESTING, make ClassRooms c1, c2, c3, c4 with their own rosters, then test with c1.alsoRegisteredIn(c2,c3,c4). If others is null or empty, return a copy of roster.

Question 4. Write a similar method public static List<Student> registeredInAll(ClassRoom... others), which returns a list of all the Students that are registered in all the ClassRooms in others. If others is null or empty, return an empty list.

Question 5. Write a method public static List<Student> registeredInOne(ClassRoom... others), which returns a list (that is sorted by id--using sortById(List<Student> list)) of all the Students that are registered in AT LEAST ONE the ClassRooms in others. This list MUST NOT contain duplicates. If others is null or empty, return an empty list. SIMPLIFICATION It is OK to use if(!returnList.contains(student)) before adding student to the returnList.

Question 6. Write ClassRoomTester1 that has tests for all the new methods you have added to ClassRoom.
