package shallowvsdeepcopy;

public class Employee implements Cloneable{
    private String name;
    private Address addr;

    public Employee() {
    }

    public Employee(String name, Address addr) {
        this.name = name;
        this.addr = addr;
    }
    
    //shallow copy
//    public Employee(Employee emp) {
//        this.name = emp.name;
//        this.addr = emp.addr;
//    }
    
    //deep copy
    public Employee(Employee emp){
        this.name = emp.name;
        this.addr = new Address(emp.addr);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddr() {
        return addr;
    }

    public void setAddr(Address addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "Employee{" + "name=" + name + ", addr=" + addr.toString() + '}';
    }
    
    //shallow copy
//    @Override
//    public Object clone()throws CloneNotSupportedException{
//        return super.clone();
//    }
       
    //deep copy
//    @Override
//    public Object clone() throws CloneNotSupportedException{
//        Employee emp = (Employee)super.clone();
//        emp.setAddr((Address)addr.clone());
//        return emp;
//    }
    
}
