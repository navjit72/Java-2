package may8exercise1;
public abstract class Shape {
    protected double x;
    protected double y;

    public Shape(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    
    public abstract double getArea();
    
    public abstract String getPoints();
}
