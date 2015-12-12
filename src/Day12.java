import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

/**
 * @author daniel.rejment@tacton.com (2015-12-12)
 */
public class Day12 {
    public static void main(String[] args) throws IOException {
        System.out.println(sum(JSONObject.parse(new String(Files.readAllBytes(Paths.get("src/day12.txt"))))));
    }

    private static int sum(JSONObject o) {
        if (o.isNumber()) {
            return o.asInteger();
        } else if (o.isList()) {
            return o.values().stream().mapToInt(Day12::sum).sum();
        } else if (o.isObject()) {
            if (o.entrySet().stream().map(Map.Entry::getValue).map(JSONObject::asString).anyMatch(n -> n.equals("red"))) {
                return 0;
            }
            return o.entrySet().stream().map(Map.Entry::getValue).mapToInt(Day12::sum).sum();
        } else {
            return 0;
        }
    }
}
