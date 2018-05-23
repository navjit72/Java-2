package comparatorvscomparable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class EmployeeTest {
    
    //declaring instance variables
    Scanner input = new Scanner(System.in);
    List<Employee> employees = new ArrayList<>();
    
    //method to fill up the employee list with information input by user.
    public void loadEmployeeList(){
        String in="y";
        String name;
        double salary;
        while(!in.equals("n")){
            System.out.println("Please enter name of employee: ");
            name = input.next();
            System.out.println("Please enter salary of employee: ");
            salary = input.nextDouble();
            employees.add(new Employee(name, salary));
            System.out.println("Do you want to continue? (y/n)");
            in=input.next();
        }  
    }
    
    //method to sort the employees firstly according to salary and then according to name.
    public void sortEmployees(){
//            employees.sort(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName));
            
//              Collections.sort(employees, new EmployeeComparator());
              Collections.sort(employees);
              System.out.println("Employee list is successfully sorted.");
              
    }
    
    //method to display the employee list with each employee's information.
    public void displayList(){
        System.out.println("Employee list: ");
        for(Employee e: employees)
            System.out.println(e.toString());
    }
    
    public static void main(String[] args) {
        EmployeeTest etest = new EmployeeTest();
        etest.loadEmployeeList();
        etest.sortEmployees();
        etest.displayList();
    }
    
}
