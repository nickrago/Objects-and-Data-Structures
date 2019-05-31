package assignment01;

public class Triangle{
  private double refAngle;
  private double sideA;
  private double angle;
  private double sideB;
  private double xBase;
  private double yBase;

  private Triangle(double angl1, double aSide, double angl2, double bSide, double x, double y){
    this.refAngle = angl1;
    this.sideA = aSide;
    this.angle = angl2;
    this.sideB = bSide;
    this.xBase = x;
    this.yBase = y;
  }

  public static Triangle makeTriangleWithRadians(double angl1, double aSide, double angl2, double bSide, double x, double y){
	   return new Triangle(angl1, aSide, angl2, bSide, x, y);
  }

  public static Triangle makeTriangleWithDegrees(double angl1, double aSide, double angl2, double bSide, double x, double y){
    return new Triangle(Math.toRadians(angl1), aSide, Math.toRadians(angl2), bSide, x, y);
  }

  public double area(){
    return (sideA * sideB * Math.sin(refAngle) * .5);
  }

  public double findX1(){
    return (xBase + sideA*Math.cos(refAngle));
  }

  public double findY1(){
    return (yBase + sideA*Math.sin(refAngle));
  }

  public double findX2(){
    return (xBase + sideB*Math.cos(refAngle + angle));
  }

  public double findY2(){
    return (yBase + sideB*Math.sin(refAngle + angle));
  }

  public double findC(){
    double x  = findX1() - findX2();
    double y = findY1() - findY2();
    return (Math.sqrt((x*x) + (y*y)));
  }

  public Rectangle doubleAreaRectangle(){
    Rectangle rect = new Rectangle(refAngle, sideA, sideB*Math.sin(angle), xBase, yBase);
    return rect;
  }
}
