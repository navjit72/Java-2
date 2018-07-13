import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

public class FileSearcher extends SimpleFileVisitor<Path> {
    PathMatcher matcher = new PathMatcher() {
        @Override
        public boolean matches(Path path) {
            return false;
        }
    };
    ArrayList<Path> pathList = new ArrayList<>();

    public FileSearcher(String pattern) {
        this.matcher = FileSystems.getDefault().getPathMatcher("glob:"+pattern);
    }


    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
        if(matcher.matches(path))
            pathList.add(path);
        return super.visitFile(path, basicFileAttributes);
    }

    public ArrayList<Path> getMatchFound()
    {
        return pathList;
    }
}
