import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author daniel.rejment@tacton.com (2015-12-01)
 */
public class Day01 {
    public static void main(String[] args) throws IOException {
        int level = 0, first = 0, position = 0;
        for (byte b : Files.readAllBytes(Paths.get("src/day1.txt"))) {
            if (b == '(') level++;
            if (b == ')') level--;
            if (level < 0 && first == 0) {
                first = position;
            }
            position++;
        }
        System.out.println(level);
        System.out.println(first);
    }
}
