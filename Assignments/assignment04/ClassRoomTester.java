package assignment04.assignment04;

import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.util.Arrays;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.PrintWriter;

public class ClassRoomTester{
  public static void main(String[] args){
    ClassRoom c1 = new ClassRoom("Class One");
    ClassRoom c2 = new ClassRoom("Class Two");
    ClassRoom c3 = new ClassRoom("Class Three");
    ClassRoom c4 = new ClassRoom("Class Four");
    ClassRoom c5 = new ClassRoom("Class Five");

    //creates ArrayList of studentList
    ArrayList<Student> studentList = new ArrayList<Student>();
    for(int i = 0; i<100; i++){
      studentList.add(Resources.getStudent());
    }

    //adds students to class based off of given rules
    for(int i = 0; i<100; i++){
      if(i%2 == 0) c1.addStudent(studentList.get(i));
    }
    for(int j = 0; j<100; j++){
      if(j%3 == 0) c2.addStudent(studentList.get(j));
    }
    for(int k = 0; k<100; k++){
      if(k%4 == 0) c3.addStudent(studentList.get(k));
    }
    for(int l = 0; l<100; l++){
      if(l%5 == 0) c4.addStudent(studentList.get(l));
    }
    for(int m = 0; m<100; m++){
      if(m%6 == 0) c5.addStudent(studentList.get(m));
    }

    //saving each to separate file
    saveClassRoom(c1);
    saveClassRoom(c2);
    saveClassRoom(c3);
    saveClassRoom(c4);
    saveClassRoom(c5);
  }

  public static void saveClassRoom(ClassRoom cRoom){
    try (PrintWriter pw = new PrintWriter(cRoom.getClassName() + ".text")){
      pw.println(cRoom);
    } catch (FileNotFoundException e){
      e.printStackTrace();
    }
  }

  public static ClassRoom readClassRoom(String fileName){
    ClassRoom cRoom = null;
    try(Scanner input = new Scanner(new File(fileName))){
      cRoom = new ClassRoom(input.nextLine().trim());
      int i = input.nextInt();
      String name = input.nextLine();
      cRoom.addStudent(new Student(i, name));
    } catch(FileNotFoundException e){
      System.out.println("Error occured, file not found.");
    } catch(Exception e){
      System.out.println("Error occured while extracting data:\n");
      e.printStackTrace();
    }
    return cRoom;
  }

}


/*
stopped at:
Write a method public static ClassRoom readClassRoom(String fileName) which will read the file back into memory.
*/
