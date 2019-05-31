package assignment03;
import java.util.List;
import java.util.ArrayList;

public class ClassRoomTester1{
  public static void main(String[] args){
    ClassRoom classRoom = new ClassRoom();
  	classRoom.addStudent(new Student(15, "Gina"));
  	classRoom.addStudent(new Student(3, "Tyler"));
  	classRoom.addStudent(new Student(4, "Arnold"));
  	classRoom.addStudent(new Student(1, "Jessica"));
  	classRoom.addStudent(new Student(2, "Richard"));

    ClassRoom c1 = new ClassRoom();
    c1.addStudent(new Student(8, "Nick"));
    c1.addStudent(new Student(4, "Arnold"));
    c1.addStudent(new Student(15, "Gina"));
    c1.addStudent(new Student(3, "Tyler"));
    c1.addStudent(new Student(7, "Pietro"));

    ClassRoom c2 = new ClassRoom();
    c2.addStudent(new Student(3, "Tyler"));
    c2.addStudent(new Student(4, "Arnold"));
    c2.addStudent(new Student(6, "Nate"));
    c2.addStudent(new Student(5, "Marie"));
    c2.addStudent(new Student(12, "Michael"));

    ClassRoom c3 = new ClassRoom();
    c3.addStudent(new Student(3, "Tyler"));
    c3.addStudent(new Student(4, "Arnold"));
    c3.addStudent(new Student(9, "Laura"));
    c3.addStudent(new Student(18, "Aliah"));
    c3.addStudent(new Student(15, "Gina"));

    ClassRoom c4 = new ClassRoom();
    c4.addStudent(new Student(3, "Tyler"));
    c4.addStudent(new Student(4, "Arnold"));
    c4.addStudent(new Student(17, "Jesse"));
    c4.addStudent(new Student(15, "Gina"));
    c4.addStudent(new Student(16, "David"));


    System.out.println("**************Original Class Roster**********");
    System.out.println(classRoom);

    System.out.println("\n*******Testing sortById(List<Student> list)**********");
    //should sort both c1 and c2 by IDs of the students
    classRoom.sortById(c1.getRoster());
    System.out.println(c1);
    classRoom.sortById(c2.getRoster());
    System.out.println(c2);

    System.out.println("\n*******Testing isRegistered()**********");
    //should return false for id = 8 and true for id = 1
    System.out.println(classRoom.isRegistered(8));
    System.out.println(classRoom.isRegistered(1));

    System.out.println("\n*******Testing alsoRegisteredIn(ClassRoom... others)**********");
    //Should print out Tyler and Arnold and Gina
    System.out.println(c1.alsoRegisteredIn(c2,c3,c4));

    System.out.println("\n*******Testing registeredInAll(ClassRoom... others)**********");
    //Should print out Tyler and Arnold
    System.out.println(ClassRoom.registeredInAll(c1,c2,c3,c4));

    System.out.println("\n*******Testing registeredInOne(ClassRoom... others)**********");
    //Should print out Tyler and Arnold and Gina
    System.out.println(ClassRoom.registeredInOne(c1,c2,c3,c4));
  }

}
