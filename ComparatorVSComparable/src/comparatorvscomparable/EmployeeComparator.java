package comparatorvscomparable;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee>{

    @Override
    public int compare(Employee t, Employee t1) {
        if(t.getSalary() > t1.getSalary())
            return 1;
        else if(t.getSalary()<t1.getSalary())
            return -1;
        else
            return 0;       
    }
    
}
