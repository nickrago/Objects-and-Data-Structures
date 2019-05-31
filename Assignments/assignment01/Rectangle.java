package assignment01;

public class Rectangle{
  private double refAngle;
  private double sideA;
  private double sideB;
  private double xBase;
  private double yBase;

  public Rectangle(double angl1, double aSide, double bSide, double x, double y){
    this.refAngle = angl1;
    this.sideA = aSide;
    this.sideB = bSide;
    this.xBase = x;
    this.yBase = y;
  }

  public double area(){
    return (sideA * sideB);
  }

  public double findX1(){
    return (xBase + (sideA * Math.cos(refAngle)));
  }

  public double findY1(){
    return (yBase + (sideA * Math.sin(refAngle)));
  }

  public double findX2(){
      return (xBase + (sideB * Math.cos(refAngle + (Math.PI / 2))));
  }

  public double findY2(){
    return (yBase + (sideB * Math.sin(refAngle + (Math.PI / 2))));
  }

  public double findX3(){
    return (findX1() + findX2() - xBase);
  }

  public double findY3(){
    return (findY1() + findY2() - yBase);
  }

  public double findC(){
    double x4 = findX3() - xBase;
    double y4 = findY3() - yBase;
    return (Math.sqrt(x4*x4 + y4*y4));
  }

  public double findAngle(){
    return Math.atan(sideB/sideA);
  }

  public Triangle extractTriangle(){
      return Triangle.makeTriangleWithRadians(refAngle, sideA, findAngle(), sideB, xBase, yBase);
  }
}
