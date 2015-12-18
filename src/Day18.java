import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author daniel.rejment@tacton.com (2015-12-18)
 */
public class Day18 {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("src/day18.txt"));
        int[][] in = new int[102][102];
        for (int y = 0; y < 100; y++) {
            for (int x = 0; x < 100; x++) {
                in[y + 1][x + 1] = lines.get(y).charAt(x) == '#' ? 1 : 0;
            }
        }

        for (int i = 0; i < 100; i++) {
            in[1][1] = in[100][1] = in[100][100] = in[1][100] = 1;
            int[][] out = new int[102][102];
            for (int y = 1; y < 101; y++) {
                for (int x = 1; x < 101; x++) {
                    int sum = (in[y - 1][x - 1] + in[y - 1][x] + in[y - 1][x + 1] + in[y][x - 1] + in[y][x + 1] + in[y + 1][x - 1] + in[y + 1][x] + in[y + 1][x + 1]);
                    out[y][x] = in[y][x] == 1 ? sum == 2 || sum == 3 ? 1 : 0 : sum == 3 ? 1 : 0;
                }
            }
            in = out;
            in[1][1] = in[100][1] = in[100][100] = in[1][100] = 1;
        }

        System.out.println(Stream.of(in).mapToInt(l-> IntStream.of(l).sum()).sum());
    }
}
