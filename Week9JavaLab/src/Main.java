import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //declaring all persistence variables
        Scanner input = new Scanner(System.in);
        Connection connection=null;
        Connection oracleConnection;
        Statement statement=null;
        Statement ostatement = null;
        PreparedStatement pstatement=null;
        PreparedStatement opstatement=null;
        ResultSet resultset=null;
        ResultSet movieset=null;
        ResultSet bookset=null;

        try {
            //initializing the connection with MySQL
            connection = DriverManager.getConnection("jdbc:mysql://localhost/sakila", "root", "navjithumber");

            //initializing the connection with oracle using humber credentials
            oracleConnection = DriverManager.getConnection("jdbc:oracle:thin:@calvin.humber.ca:1521:grok","n01267930","oracle");

            //creating a statement for the MySQL connection
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            //creating a statement for the oracle connection
            ostatement = oracleConnection.createStatement();

            //prepared statement to fetch data from film table based on the length condition
            pstatement = connection.prepareStatement("Select * from film where length < ?",
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            //pstatement.setDouble(1, 90.0);

            //prepared statement to fetch data from books based on the price condition
            opstatement = oracleConnection.prepareStatement("Select * from Books where retail < ?");

            //fetching data in resultset from MySQL
            resultset = statement.executeQuery("Select * from actor");

            //fetching data in resultset from oracle
            bookset =ostatement.executeQuery("Select * from Books");

            System.out.println("Actors : ");

            //displaying the first record in actor table
            if (resultset.first()) {
                System.out.println("First record : \n" + resultset.getString(1) + "\t" + resultset.getString(2) + "\t" +
                        resultset.getString(3) + "\t" + resultset.getString(4));
            }

            //displaying the 100th record in actor table
            while (resultset.next()) {
                if (resultset.getRow() == 100) {
                    System.out.println("100th record : \n" + resultset.getString(1) + "\t" + resultset.getString(2) + "\t" +
                            resultset.getString(3) + "\t" + resultset.getString(4));
                }
            }

            //displaying the last record in actor table
            if (resultset.last()) {
                System.out.println("Last record : \n" + resultset.getString(1) + "\t" + resultset.getString(2) + "\t" +
                        resultset.getString(3) + "\t" + resultset.getString(4));
            }
            System.out.println();

            //displaying all the records from actor table exposing 20 records at a time
            int end = 20;
            int counter = 1;

            resultset.beforeFirst();

            while (counter <= 200) {
                while (resultset.next() && counter <= end) {
                    System.out.println(resultset.getString(1) + "\t" + resultset.getString(2) + "\t" +
                            resultset.getString(3) + "\t" + resultset.getString(4));
                    counter++;
                }

                if(end!=200) {
                    System.out.println("Press any key to continue....");
                    System.in.read();
                    end += 20;
                }
                resultset.previous();
            }
            System.out.println();

            System.out.println("Enter the minimum length of films : ");
            //getting input for length of a film from the user.
            pstatement.setDouble(1,input.nextDouble());
            movieset = pstatement.executeQuery();

            System.out.println();

            System.out.println("Movies : ");

            //displaying the movie records having length less than the provided length
            while(movieset.next())
            {
                System.out.println(movieset.getString(1) + "\t" + movieset.getString(2) + "\t" +
                        movieset.getString(3) + "\t" + movieset.getString(4));
            }

            System.out.println();

            //displaying all book records.
            System.out.println("Books : ");
            while(bookset.next()){
                System.out.println(bookset.getString(1) + "\t" + bookset.getString(2)+ "\t" + bookset.getString(6));
            }
            System.out.println();

            System.out.println("Enter retail price for books : ");
            //getting input for retail price from user.
            opstatement.setDouble(1,input.nextDouble());
            bookset = opstatement.executeQuery();

            System.out.println();

            //displaying only those books having retail price under the provided price.
            System.out.println("Books under given retail price : ");
            while(bookset.next()){
                System.out.println(bookset.getString(1) + "\t" + bookset.getString(2)+ "\t" + bookset.getString(6));
            }


            bookset.close();
            resultset.close();
            movieset.close();
            ostatement.close();
            statement.close();;
            pstatement.close();
            oracleConnection.close();
            connection.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
