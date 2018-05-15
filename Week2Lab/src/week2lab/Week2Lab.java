package week2lab;

import java.util.Scanner;

public class Week2Lab {
    public static void main(String[] args) {
        PostalCode pc = new PostalCode();
        Scanner s = new Scanner(System.in);
        try {
            System.out.println(pc.readPostalCode(s));
        } catch (InvalidPostalCodeException ex) {
            System.out.println(ex);;
        }
    }
    
}
