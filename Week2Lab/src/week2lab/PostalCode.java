package week2lab;
import java.util.Scanner;

public class PostalCode {
    
    public String readPostalCode(Scanner s) throws InvalidPostalCodeException{
        System.out.println("Enter Postal Code : ");
        String input = s.nextLine();
        input = input.trim();
        input = input.toUpperCase();
        String newString="";
        for(int i=0;i<input.length();i++){
            if(!Character.isSpaceChar(input.charAt(i)))
                newString+=input.charAt(i);
        }
        if(newString.length()!=6)
            throw new InvalidPostalCodeException("Postal Code should be of 6 characters.");
        
        String newString2="";
        for(int i=0;i<6;i++)
        {
            if(!Character.isAlphabetic(newString.charAt(i))){
                    if(!Character.isDigit(newString.charAt(i)))
                        throw new InvalidPostalCodeException("Special characters not allowed.");   }
            else if(i==1 || i==3 || i==5)
            {
                if(!Character.isDigit(newString.charAt(i)))
                    throw new InvalidPostalCodeException("Number expected alternatively starting from position 2.");
            }
            if(i==3)
                newString2+=" ";
            newString2+=newString.charAt(i);
        }
        return newString2;
    }
    
}
