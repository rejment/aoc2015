import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.IntStream;

/**
 * @author daniel.rejment@tacton.com (2015-12-24)
 */
public class Day24 {
    public static void main(String[] args) throws IOException {
        int[] sizes = Files.lines(Paths.get("src/day24.txt")).mapToInt(Integer::parseInt).toArray();

        System.out.println(divide(sizes, 3));
        System.out.println(divide(sizes, 4));
    }

    private static long divide(int[] sizes, int divisions) {
        int pack = IntStream.of(sizes).sum() / divisions;
        long min = Long.MAX_VALUE;
        for (int l = 1; l < sizes.length; l++) {
            for (int i = (1 << l) - 1; i > 0; i = next(i)) {

                long sum = 0;
                long prod = 1;
                for (int b = 0; b < sizes.length; b++) {
                    if ((i & (1 << b)) != 0) {
                        sum += sizes[b];
                        prod *= sizes[b];
                    }
                }
                if (sum == pack) {
                    min = Math.min(min, prod);
                }
            }
            if (min != Long.MAX_VALUE) {
                return min;
            }
        }
        throw new RuntimeException();
    }

    private static int next(int x) {
        int rightOne = x & -x;
        int nextHigherOneBit = x + rightOne;
        int rightOnesPattern = x ^ nextHigherOneBit;
        rightOnesPattern = (rightOnesPattern) / rightOne;
        rightOnesPattern >>= 2;
        return nextHigherOneBit | rightOnesPattern;
    }
}
