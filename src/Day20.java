import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author daniel.rejment@tacton.com (2015-12-20)
 */
public class Day20 {

    public static void main(String[] args) {
        int input = 34000000;

        int[] sieve = new int[1000000];
        IntStream.range(1, sieve.length).forEach(elf ->
                IntStream.range(1, ((sieve.length + elf - 1) / elf)).forEach(j ->
                        sieve[j * elf] += elf * 10));
        System.out.println(IntStream.range(1, sieve.length).filter(i -> sieve[i] > input).findFirst().getAsInt());

        Arrays.fill(sieve, 0);
        IntStream.range(1, sieve.length).forEach(elf ->
                IntStream.range(1, Math.min(50, ((sieve.length + elf - 1) / elf))).forEach(j ->
                        sieve[j * elf] += elf * 11));
        System.out.println(IntStream.range(1, sieve.length).filter(i -> sieve[i] > input).findFirst().getAsInt());
    }
}
