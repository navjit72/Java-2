package may8exercise1;

public class May8Exercise1 {

    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        for(Shape s: shapes){
            shapes[0] = new Rectangle(1, 2, 3, 5);
            shapes[1] = new Circle(0,0,6);
            shapes[2] = new Triangle(1, 2, 3, 4, 5);
        }
        
//        System.out.println("Rectangle: ");
//        Shape r = new Rectangle(3,4,5, 6);
//        System.out.println(r.getArea());
//        System.out.println(r.getPoints());
//        System.out.println("-----------------------------");
//        System.out.println("Rectangle: ");
//        Shape c = new Circle(2,1,5);
//        System.out.println(c.getArea());
//        System.out.println(c.getPoints());
//        System.out.println("-----------------------------");
//        System.out.println("Rectangle: ");
//        Shape t = new Triangle(0,0,3, 6,2);
//        System.out.println(t.getArea());
//        System.out.println(t.getPoints());
//        System.out.println("-----------------------------");
    }   
}
