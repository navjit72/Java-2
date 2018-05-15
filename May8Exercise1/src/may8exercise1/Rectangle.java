package may8exercise1;

public class Rectangle extends Shape{
    
    private double width;
    private double height;

    public Rectangle(double x, double y, double width, double height) {
        super(x,y);
        this.width = width;
        this.height = height;
    }
    
    public double getArea() {
        return width*height;
    }
    
    public String getPoints(){
        double x1=x;
        double y1=y;
        double x2=x+width;
        double y2=y;
        double x3=x;
        double y3=y+height;
        double x4=x2;
        double y4=y3;
        return "First Point = ("+x1+","+y1+") Second point = ("+x2+","+y2+") "
                + "Third Point = ("+x3+","+y3+") Fourth point = ("+x4+","+y4+")";
    }
    
}
