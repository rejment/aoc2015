import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author daniel.rejment@tacton.com (2015-12-08)
 */
public class Day08 {
    public static void main(String[] args) throws IOException {
        int [] sum = {0, 0};
        Files.lines(Paths.get("src/day8.txt")).forEach(l->{
            String d = l.replaceAll("\\\\(\\\\|\"|x[0-9a-f][0-9a-f])", "_");
            sum[0] += l.length() - (d.length() - 2);
        });
        System.out.println(sum[0]);

        sum[1] = 0;
        Files.lines(Paths.get("src/day8.txt")).forEach(l->{
            String d = l.replaceAll("[\"\\\\]", "__");
            sum[1] += (d.length() + 2) - l.length();
        });
        System.out.println(sum[1]);
    }
}
