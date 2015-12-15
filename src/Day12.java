import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author daniel.rejment@tacton.com (2015-12-12)
 */
public class Day12 {
    public static void main(String[] args) throws IOException {
        Pattern obj = Pattern.compile("\\{[^{}]*\\}");
        String input = new String(Files.readAllBytes(Paths.get("src/day12.txt")));
        System.out.println(getSum(input));

        while (input.contains("{")) {
            Matcher m = obj.matcher(input);
            if (m.find()) {
                input = input.replace(m.group(), m.group().contains(":\"red\"") ? "0" : Integer.toString(getSum(m.group())));
            }
        }
        System.out.println(getSum(input));
    }

    private static int getSum(String input) {
        Matcher matcher = Pattern.compile("-?\\d+").matcher(input);
        int sum = 0;
        while (matcher.find()) {
            sum += Integer.parseInt(matcher.group(0));
        }
        return sum;
    }
}
