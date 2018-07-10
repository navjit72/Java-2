import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;

public class NavjitKaurWeek10Test {
    public static void main(String[] args) {
        try {
            //Question 1
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/Northwind", "root", "navjithumber");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from customer");

            //Question 2
            System.out.println("customer_Id, first_name, last_name, email, tel_no");
            while (resultSet.next())
            {
                System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t" +
                        resultSet.getString(3) + "\t" + resultSet.getString(4) + "\t" + resultSet.getString(5));
            }

            //Question 3
            Path dir = Paths.get("textfiles");
            Files.createDirectories(dir);
            FileWriter fw = new FileWriter("textfiles/customer.csv");
            fw.append("hello,");
            fw.append("hi there\n");
            fw.append("navjit");
            while(resultSet.next()){
                fw.append(resultSet.getString(1)+","+resultSet.getString(2)+","+resultSet.getString(3)+
                        ","+resultSet.getString(4)+","+resultSet.getString(5)+"\n");
            }
            fw.close();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
