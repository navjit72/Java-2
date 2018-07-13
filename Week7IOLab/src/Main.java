import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> arrList = new ArrayList<>();
        try(
                FileReader fr = new FileReader("files/xanadu.txt");
                BufferedReader br = new BufferedReader(fr);
//                FileWriter fw = new FileWriter("files/newxanadu.txt");

        ){
//        try{
//            Path source = Paths.get("files/xanadu.txt");
//            Path target = Paths.get("files/newxanadu.txt");
//            Files.copy(source,target,StandardCopyOption.REPLACE_EXISTING);
//            System.out.println("First File copied");
//
//            Path target1=Paths.get("files/newxanadu2.txt");
//            Files.copy(source,target1,StandardCopyOption.REPLACE_EXISTING);
//            System.out.println("Second File copied");
//
//            Path dir = Paths.get("files/tempDir");
//            Files.createDirectory(dir);
//
//            Files.move(target1,dir.resolve(target1.getFileName()),StandardCopyOption.REPLACE_EXISTING);

//            Files.delete(target1);
//            System.out.println("Second file deleted");

//            int ch;
//            while((ch=fr.read())!=-1)
//            {
//                System.out.print((char)ch);
//            }
            String line = null;
            while((line=br.readLine())!=null)
            {
                arrList.add(line);
            }
            for (String text: arrList) {
                System.out.println(text);
            }
        }
        catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
