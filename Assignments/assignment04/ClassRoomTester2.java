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

public class ClassRoomTester2{
  public static void main(String[] args){
    ClassRoom classOne = readClassRoom("Class One.text");
    ClassRoom classTwo = readClassRoom("Class Two.text");
    ClassRoom classThree = readClassRoom("Class Three.text");
    ClassRoom classFour = readClassRoom("Class Four.text");
    ClassRoom classFive = readClassRoom("Class Five.text");

    System.out.println(classOne.alsoRegisteredIn(classTwo));
    //System.out.println(classOne.alsoRegisteredIn(classTwo, classThree, classFour, classFive));
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
      while(input.hasNext()){
        int i = input.nextInt();
        String name = input.nextLine();
        cRoom.addStudent(new Student(i, name));
      }
    } catch(FileNotFoundException e){
      System.out.println("Error occured, file not found.");
    }
    return cRoom;
  }

}
