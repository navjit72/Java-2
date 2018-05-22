package shallowvsdeepcopy;

public class ShallowVSdeepCopy {

    public static void main(String[] args) {
        Address ad1 = new Address(10, "ON");
        Employee emp1 = new Employee("Abc", ad1);
        System.out.println(emp1.toString());
//        try {
            Employee emp2 = new Employee(emp1);
            System.out.println(emp2.toString());
            ad1.setHouseNum(27);
            System.out.println("After changes: ");
            System.out.println(emp1.toString());
            System.out.println(emp2.toString());
//        } catch (CloneNotSupportedException ex) {
//            System.out.println("Exception");
//        }
        
    }
    
}
