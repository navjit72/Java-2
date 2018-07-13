import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Main {
    public static void main(String[] args) {
        Path source = Paths.get("textfile.txt");
        Path target = Paths.get("textfile2.txt");
        try {
            Files.copy(source,target,StandardCopyOption.REPLACE_EXISTING);
            Files.delete(target);
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

//        try{
//            FileReader fr = new FileReader("textfile.txt");
//            BufferedReader br = new BufferedReader(fr);
//            FileWriter fw = new FileWriter("textfile2.txt");
//            int c=0;
//
//            String line = null;
//            while((line=br.readLine())!=null)
//            {
//                System.out.println(line);
//               fw.write(line);
//            }
//            System.out.println();
//        }
//        catch(FileNotFoundException ex)
//        {
//            System.out.println(ex.getMessage());
//        }
//        catch(IOException ex)
//        {
//            System.out.println(ex.getMessage());
//        }
    }
}

