import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author daniel.rejment@tacton.com (2015-12-13)
 */
public class Day13 {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> gains = new HashMap<>();
        List<String> list = new ArrayList<>();
        Pattern r = Pattern.compile("([a-z]+) would (gain|lose) ([0-9]+) happiness units by sitting next to ([a-z]+)\\.");
        Files.lines(Paths.get("src/day13.txt")).forEach(l -> {
            Matcher matcher = r.matcher(l.toLowerCase());
            if (!matcher.matches()) throw new RuntimeException();
            gains.put(matcher.group(1) + "-" + matcher.group(4), Integer.parseInt(matcher.group(3)) * ("gain".equals(matcher.group(2)) ? 1 : -1));
            if (!list.contains(matcher.group(1))) {
                list.add(matcher.group(1));
            }
        });

        for (String a : list) {
            gains.put("me-" + a, 0);
            gains.put(a + "-me", 0);
        }
        list.add("me");

        int [] max = {0};
        permutations(list, l -> {
            int gain = 0;
            for (int i = 0; i < l.size(); i++) {
                String a = l.get(i);
                String b = l.get(i == 0 ? (l.size() - 1) : i - 1);
                String c = l.get(i == l.size() - 1 ? 0 : i + 1);
                gain += gains.get(a + "-" + b);
                gain += gains.get(a + "-" + c);
            }
            max[0] = Math.max(max[0], gain);
        }, 0);
        System.out.println(max[0]);
    }

    private static <T> void permutations(List<T> arr, Consumer<List<T>> callback, int k) {
        for (int i = k; i < arr.size(); i++) {
            Collections.swap(arr, i, k);
            permutations(arr, callback, k + 1);
            Collections.swap(arr, k, i);
        }
        if (k == arr.size() - 1) {
            callback.accept(arr);
        }
    }
}
