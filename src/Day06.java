import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author daniel.rejment@tacton.com (2015-12-06)
 */
public class Day06 {
    public static void main(String[] args) throws IOException {
        Pattern compile = Pattern.compile("(turn on|turn off|toggle) (\\d+),(\\d+) through (\\d+),(\\d+)");
        int[][] lights = new int[1000][1000];
        int[][] lights2 = new int[1000][1000];
        for (String line : Files.readAllLines(Paths.get("src/day6.txt"))) {
            Matcher matcher = compile.matcher(line);
            if (matcher.matches()) {
                for (int x = Integer.parseInt(matcher.group(2)); x <= Integer.parseInt(matcher.group(4)); x++) {
                    for (int y = Integer.parseInt(matcher.group(3)); y <= Integer.parseInt(matcher.group(5)); y++) {
                        if (matcher.group(1).equals("turn on")) {
                            lights[x][y] = 1;
                            lights2[x][y] += 1;
                        }
                        if (matcher.group(1).equals("turn off")) {
                            lights[x][y] = 0;
                            if (lights2[x][y] > 0)
                                lights2[x][y] -= 1;
                        }
                        if (matcher.group(1).equals("toggle")) {
                            lights[x][y] = 1 - lights[x][y];
                            lights2[x][y] += 2;
                        }
                    }
                }
            }
        }
        System.out.println(Stream.of(lights).flatMapToInt(IntStream::of).sum());
        System.out.println(Stream.of(lights2).flatMapToInt(IntStream::of).sum());
    }
}

