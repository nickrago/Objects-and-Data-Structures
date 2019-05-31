package assignment01;

public class Tester{

  public static void main(String[] args){

    //TESTING BookForClass.java
    BookForClass BookOne = new BookForClass(264, "A Place to Stand");
    System.out.println("Testing BookForClass.java\n~~~~~");
    System.out.println("Pages Needed to Read Per Day: " + BookOne.pagesNeededPerDayToRead(10));
    System.out.println("Days Needed to Read: " + BookOne.daysNeededToRead(5));
    System.out.println("~~~~~\n\n");

    //TESTING Rectangle.java
    Rectangle RecOne = new Rectangle(3.14, 5, 7, 1, 1);
    System.out.println("Testing Rectangle.java:\n~~~~~");
    System.out.println("Area: " + RecOne.area());
    System.out.println("X1: " + RecOne.findX1());
    System.out.println("Y1: " + RecOne.findY1());
    System.out.println("X2: " + RecOne.findX2());
    System.out.println("Y2: " + RecOne.findY2());
    System.out.println("X3: " + RecOne.findX3());
    System.out.println("Y3: " + RecOne.findY3());
    System.out.println("C: " + RecOne.findC());
    System.out.println("Angle: " + RecOne.findAngle());

    System.out.println("Exact Triangle: " + RecOne.extractTriangle());
    System.out.println("~~~~~\n\n");

    //TESTING Triangle.java
    Triangle TriOne = Triangle.makeTriangleWithRadians(3, 4, 5, 7, 2, 2);
    System.out.println("Testing Triangle.java:\n~~~~~");
    System.out.println("Area: " + TriOne.area());
    System.out.println("X1: " + TriOne.findX1());
    System.out.println("Y1: " + TriOne.findY1());
    System.out.println("X2: " + TriOne.findX2());
    System.out.println("Y2: " + TriOne.findY2());
    System.out.println("C: " + TriOne.findC());
    System.out.println("Double Area Rectangle: " + TriOne.doubleAreaRectangle());
    System.out.println("~~~~~\n\n");

  }


}
