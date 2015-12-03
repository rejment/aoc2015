import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;

/**
 * @author daniel.rejment@tacton.com (2015-12-03)
 */
public class Day03 {
    public static void main(String[] args) throws IOException {
        BiConsumer<Byte, Point> mover = (b, p) -> {
            if (b == '<') p.translate(-1, 0);
            if (b == '>') p.translate(1, 0);
            if (b == '^') p.translate(0, -1);
            if (b == 'v') p.translate(0, 1);
        };
        Set<String> houses = new HashSet<>();
        Point p = new Point(0, 0);
        houses.add(p.toString());
        for (byte b : Files.readAllBytes(Paths.get("src/day3.txt"))) {
            mover.accept(b, p);
            houses.add(p.toString());
        }
        System.out.println(houses.size());

        houses.clear();
        Point p1 = new Point(0, 0), p2 = new Point(0, 0);
        houses.add(p1.toString());
        for (byte b : Files.readAllBytes(Paths.get("src/day3.txt"))) {
            mover.accept(b, p1);
            houses.add(p1.toString());
            Point tmp = p1;
            p1 = p2;
            p2 = tmp;
        }
        System.out.println(houses.size());
    }
}
