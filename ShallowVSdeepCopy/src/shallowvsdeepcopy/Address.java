package shallowvsdeepcopy;

public class Address implements Cloneable{
    private int houseNum;
    private String State;

    public Address() {
    }
    
    public Address(int houseNum, String State) {
        this.houseNum = houseNum;
        this.State = State;
    }
    
    //deep copy
    public Address(Address add){
        this.houseNum = add.houseNum;
        this.State = add.State;
    }

    public int getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(int houseNum) {
        this.houseNum = houseNum;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    @Override
    public String toString() {
        return "Address{" + "houseNum=" + houseNum + ", State=" + State + '}';
    }
    
    //deep copy
//    @Override
//    public Object clone() throws CloneNotSupportedException{
//        Address ad = (Address)super.clone();
//        return ad;
//    }
    
    
}
