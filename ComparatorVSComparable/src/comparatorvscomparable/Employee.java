package comparatorvscomparable;

public class Employee implements Comparable<Employee>{
    
    //declaring instance variables
    private String name;
    private double salary;

    //default constructor
    public Employee() {
    }

    //parameterized constructor
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    //to string method overriden to display employee information
    @Override
    public String toString() {
        return "Employee{" + "name=" + name + ", salary=" + salary + '}';
    }

    @Override
    public int compareTo(Employee t) {
        if(this.getSalary() > t.getSalary())
            return 1;
        else if(this.getSalary()<t.getSalary())
            return -1;
        else
            return 0; 
    }
    
}
