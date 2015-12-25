import static java.math.BigInteger.valueOf;

/**
 * @author daniel.rejment@tacton.com (2015-12-25)
 */
public class Day25 {
    public static void main(String[] args) {
        int row = 2947;
        int col = 3029;
        int answer = valueOf(252533).modPow(valueOf((row + col - 2) * (row + col - 1) / 2 + col - 1), valueOf(33554393)).multiply(valueOf(20151125)).mod(valueOf(33554393)).intValue();
        System.out.println(answer);
    }
}
