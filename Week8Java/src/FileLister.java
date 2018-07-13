import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class FileLister extends SimpleFileVisitor<Path> {
    private int tabcount=0;

    @Override
    public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
        tabcount++;
        System.out.println();
        for(int i=0;i<tabcount;i++)
        {
            System.out.print("\t");
        }
        System.out.print(path.getFileName() + " <dir>");
        return super.preVisitDirectory(path, basicFileAttributes);
    }

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
        System.out.println();
        System.out.print("\t");
        for(int i=0;i<tabcount;i++)
        {
            System.out.print("\t");
        }
        if(basicFileAttributes.isRegularFile())
            System.out.print(path.getFileName());


        return super.visitFile(path, basicFileAttributes);
    }

    @Override
    public FileVisitResult postVisitDirectory(Path path, IOException e) throws IOException {
        tabcount--;
        return super.postVisitDirectory(path, e);
    }
}
