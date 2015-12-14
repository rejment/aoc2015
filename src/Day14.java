import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * @author daniel.rejment@tacton.com (2015-12-14)
 */
public class Day14 {
    public static void main(String[] args) throws IOException {
        int[][] input = Files.lines(Paths.get("src/day14.txt")).map(l ->
                Arrays.stream(l.split("[^0-9]+")).filter(s -> !s.isEmpty()).mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);

        int[] countdown = new int[input.length];
        boolean[] waiting = new boolean[input.length];
        int[] position = new int[input.length];
        int[] point = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            countdown[i] = input[i][1];
        }

        for (int s = 0; s < 2503; s++) {
            for (int i = 0; i < input.length; i++) {
                if (!waiting[i]) {
                    position[i] += input[i][0];
                }
                countdown[i] -= 1;
                if (countdown[i] == 0) {
                    waiting[i] = !waiting[i];
                    countdown[i] = input[i][waiting[i] ? 2 : 1];
                }
            }

            int maxPos = Arrays.stream(position).max().getAsInt();
            for (int i = 0; i < input.length; i++) {
                if (position[i] == maxPos) point[i]++;
            }
        }

        System.out.println(Arrays.stream(position).max().getAsInt());
        System.out.println(Arrays.stream(point).max().getAsInt());
    }
}
