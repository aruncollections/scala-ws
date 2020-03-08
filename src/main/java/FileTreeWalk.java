import java.nio.file.Files;
import java.nio.file.Paths;

public class FileTreeWalk {

    public static void main(String... sss) throws Exception {


        Files.walk(Paths.get("/Users/arunprasath/Downloads/Telematics/Lexis-Security/security"))
                //.filter(Files::isDirectory)
                .filter(f -> !f.toFile().isHidden())
                .sorted()
                .forEach(f -> System.out.println( f.toAbsolutePath()));
    }
}
