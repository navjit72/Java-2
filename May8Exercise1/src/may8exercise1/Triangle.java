package may8exercise1;

public class Triangle extends Shape{
    private double base;
    private double height;
    private double alpha;

    public Triangle(double x, double y, double base, double height, double alpha) {
        super(x,y);
        this.base = base;
        this.height = height;
        this.alpha = alpha;
    }
    
    public double getArea(){
        return (base*height)/2;
    }
    
    public String getPoints(){
        double x1=x;
        double y1=y+height;
        double x2=x+alpha;
        double y2=y;
        double x3=x+base;
        double y3=y+height;
        return "First Point = ("+x1+","+y1+") Second point = ("+x2+","+y2+") Third Point = ("+x3+","+y3+")";
    }
    
}
