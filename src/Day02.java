import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author daniel.rejment@tacton.com (2015-12-02)
 */
public class Day02 {
    public static void main(String[] args) throws IOException {
        System.out.println(Files.readAllLines(Paths.get("src/day2.txt")).stream().mapToInt(l -> {
            int[] xes = Stream.of(l.split("x")).mapToInt(Integer::parseInt).sorted().toArray();
            return 3 * xes[0] * xes[1] + 2 * xes[1] * xes[2] + 2 * xes[0] * xes[2];
        }).sum());

        System.out.println(Files.readAllLines(Paths.get("src/day2.txt")).stream().mapToInt(l -> {
            int[] xes = Stream.of(l.split("x")).mapToInt(Integer::parseInt).sorted().toArray();
            return 2 * xes[0] + 2 * xes[1] + xes[0] * xes[1] * xes[2];
        }).sum());
    }
}
