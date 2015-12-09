import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Consumer;

/**
 * @author daniel.rejment@tacton.com (2015-12-09)
 */
public class Day09 {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> distances = new HashMap<>();
        Set<String> places = new HashSet<>();
        Files.lines(Paths.get("src/day9.txt")).forEach(l -> {
            String[] split = l.split(" to | = ");
            places.add(split[0]);
            places.add(split[1]);
            distances.put(split[0] + " to " + split[1], Integer.parseInt(split[2]));
            distances.put(split[1] + " to " + split[0], Integer.parseInt(split[2]));
        });

        int [] res = {10000, 0};
        permutations(new ArrayList<>(places), (l) -> {
            int dist = 0;
            for (int i=0; i<l.size()-1; i++) {
                dist += distances.get(l.get(i) + " to " + l.get(i+1));
            }
            if (dist < res[0]) res[0] = dist;
            if (dist > res[1]) res[1] = dist;
        }, 0);

        System.out.println(res[0]);
        System.out.println(res[1]);
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
