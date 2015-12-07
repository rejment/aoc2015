import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * @author daniel.rejment@tacton.com (2015-12-07)
 */
public class Day07 {
    public static void main(String[] args) throws IOException {
        Map<String, String> exprs = new HashMap<>();
        Files.lines(Paths.get("src/day7.txt")).forEach(line -> {
            String[] split = line.split(" -> ");
            exprs.put(split[1], split[0]);
        });
        int result = evaluate("a", exprs, new HashMap<>());
        System.out.println(result);

        exprs.put("b", Integer.toString(result));
        int result2 = evaluate("a", exprs, new HashMap<>());
        System.out.println(result2);
    }

    private static int evaluate(String var, Map<String, String> expressions, Map<String, Integer> memo) {
        return memo.computeIfAbsent(var, (a) -> {
            if (a.matches("[0-9]+")) return Integer.parseInt(a);
            String expr = expressions.get(a);
            if (expr.matches("([a-z0-9]+) RSHIFT ([a-z0-9]+)"))
                return evaluate(expr.split(" RSHIFT ")[0], expressions, memo) >> evaluate(expr.split(" RSHIFT ")[1], expressions, memo);
            if (expr.matches("([a-z0-9]+) LSHIFT ([a-z0-9]+)"))
                return evaluate(expr.split(" LSHIFT ")[0], expressions, memo) << evaluate(expr.split(" LSHIFT ")[1], expressions, memo);
            if (expr.matches("([a-z0-9]+) AND ([a-z0-9]+)"))
                return evaluate(expr.split(" AND ")[0], expressions, memo) & evaluate(expr.split(" AND ")[1], expressions, memo);
            if (expr.matches("([a-z0-9]+) OR ([a-z0-9]+)"))
                return evaluate(expr.split(" OR ")[0], expressions, memo) | evaluate(expr.split(" OR ")[1], expressions, memo);
            if (expr.matches("NOT ([a-z0-9]+)")) return ~evaluate(expr.substring(4), expressions, memo);
            if (expr.matches("[a-z0-9]+")) return evaluate(expr, expressions, memo);
            return -9999;
        });
    }
}
