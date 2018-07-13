import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
//    private static final String Username = "dbuser";
//    private static final String Password = "dbpassword";
//    private static final String conn_string = "jdbc:mysql://localhost/sakila";

    public static void main(String[] args) {
//        Connection connection = null;
//        try
//        {
//            connection = DriverManager.getConnection(conn_string,Username,Password);
//        }
//        catch (SQLException e)
//        {
//            System.out.println(e.getMessage());
//        }

        Path files = Paths.get("files");
        Path source = Paths.get("files/source.txt");
        Path source1 = Paths.get("files/backup/sourceBk.txt");
        Path target = Paths.get("files/target.txt");
        Path target1 = Paths.get("files/backup/targetBk.txt");
        Path sourcework = Paths.get("files/work");

//        Charset charset = Charset.forName("US-ASCII");
//        try(
//                BufferedReader br  = Files.newBufferedReader(source,charset);
//                BufferedWriter bw = Files.newBufferedWriter(target,charset);
//        )
//        {
//            String line = null;
//            while((line=br.readLine())!=null)
//            {
//                bw.append(line);
//            }
//
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
        try
        {
//            Files.copy(source,source1,StandardCopyOption.REPLACE_EXISTING);
//            Files.copy(target,target1,StandardCopyOption.REPLACE_EXISTING);
//            Files.move(source,sourcework.resolve(source.getFileName()),StandardCopyOption.REPLACE_EXISTING);
//            Files.move(target,sourcework.resolve(target.getFileName()),StandardCopyOption.REPLACE_EXISTING);
            FileSearcher fs = new FileSearcher("*.txt");
         //   Files.walkFileTree(files,new FileLister());
            Files.walkFileTree(files,fs);
            for(Path p : fs.getMatchFound())
            {
                System.out.println(p);
            }

        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
