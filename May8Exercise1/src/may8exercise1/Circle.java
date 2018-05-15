package may8exercise1;

public class Circle extends Shape{
    private double radius;
    public static final double pi=3.14;

    public Circle(double x, double y, double radius) {
        super(x,y);
        this.radius = radius;
    }
    
    public double getArea(){
        return pi*radius*radius;
    }
    
    public String getPoints(){
        return "Center Point = ("+x+","+y+")";
    }
    
}
