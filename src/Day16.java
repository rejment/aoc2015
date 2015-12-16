import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * @author daniel.rejment@tacton.com (2015-12-16)
 */
public class Day16 {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("children", 3);
        scores.put("cats", 7);
        scores.put("samoyeds", 2);
        scores.put("pomeranians", 3);
        scores.put("akitas", 0);
        scores.put("vizslas", 0);
        scores.put("goldfish", 5);
        scores.put("trees", 3);
        scores.put("cars", 2);
        scores.put("perfumes", 1);

        Files.lines(Paths.get("src/day16.txt")).filter(l -> {
            String[] row = l.split(": |, | ");
            int score = 0;
            for (int i = 0; i < 3; i++) {
                String prop = row[i * 2 + 2];
                int value = Integer.parseInt(row[i * 2 + 3]);
                int expect = scores.get(prop);
                if ("cats".equals(prop) || "trees".equals(prop)) {
                    if (value > expect) score++;
                } else if ("pomeranians".equals(prop) || "goldfish".equals(prop)) {
                    if (value < expect) score++;
                } else if (expect == value) {
                    score++;
                }
            }
            return score == 3;
        }).forEach(System.out::println);
    }
}
