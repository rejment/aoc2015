import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * @author daniel.rejment@tacton.com (2015-12-19)
 */
public class Day19 {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("src/day19.txt"));
        String input = lines.get(lines.size() - 1);
        List<String[]> replacements = new ArrayList<>();
        for (int i = 0; i < lines.size() - 2; i++) {
            replacements.add(lines.get(i).split(" => "));
        }

        Set<String> replaced = new HashSet<>();
        for (String[] replacement : replacements) {
            for (int i = 0; i < input.length(); i++) {
                if (input.startsWith(replacement[0], i)) {
                    replaced.add(input.substring(0, i) + replacement[1] + input.substring(i + replacement[0].length()));
                }
            }
        }
        System.out.println(replaced.size());

        String restart = input;
        for (; ; ) {
            input = restart;
            Collections.shuffle(replacements); // ouch
            int count = 0;
            for (; ; ) {
                int startLength = input.length();
                for (String[] replacement : replacements) {
                    if (input.contains(replacement[1])) {
                        input = input.replaceFirst(replacement[1], replacement[0]);
                        count++;
                    }
                }
                if (input.equals("e") || startLength == input.length()) break;
            }
            if (input.equals("e")) {
                System.out.println(count);
                break;
            }
        }
    }
}
