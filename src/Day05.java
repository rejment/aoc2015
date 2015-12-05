import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

/**
 * @author daniel.rejment@tacton.com (2015-12-05)
 */
public class Day05 {
    public static void main(String[] args) throws IOException {
        Pattern vowels = compile("[aeiou].*[aeiou].*[aeiou]"), doubles = compile("([a-z])\\1"),
                excluded = compile("ab|cd|pq|xy"), pair = compile("([a-z][a-z]).*\\1"), repeat = compile("([a-z]).\\1");

        System.out.println(Files.readAllLines(Paths.get("src/day5.txt")).stream().filter(l ->
                vowels.matcher(l).find() && doubles.matcher(l).find() && !excluded.matcher(l).find()
        ).count());

        System.out.println(Files.readAllLines(Paths.get("src/day5.txt")).stream().filter(l ->
                pair.matcher(l).find() && repeat.matcher(l).find()
        ).count());
    }
}
