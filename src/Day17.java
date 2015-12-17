import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.IntStream;

/**
 * @author daniel.rejment@tacton.com (2015-12-17)
 */
public class Day17 {
    public static void main(String args[]) throws IOException {
        int[] buckets = Files.lines(Paths.get("src/day17.txt")).mapToInt(Integer::parseInt).toArray();
        int target = 150;

        int[] bitCounts = IntStream.range(1, 1 << buckets.length).filter(a ->
                IntStream.range(0, buckets.length).map(b -> ((a & (1 << b)) != 0) ? buckets[b] : 0).sum() == target
        ).map(Integer::bitCount).toArray();
        System.out.println(bitCounts.length);

        int minBits = IntStream.of(bitCounts).min().orElse(0);
        System.out.println(IntStream.of(bitCounts).filter(i -> i == minBits).count());
    }
}
