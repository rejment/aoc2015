import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author daniel.rejment@tacton.com (2015-12-11)
 */
public class Day11 {
    public static void main(String[] args) {
        String password = "vzbxkghb";

        for (int i = 0; i < 2; i++) {
            do {
                password = Long.toString(Long.parseLong(password, 36) + 1, 36).replace('0', 'a');
            }
            while (!(twoPairs(password) && password.matches(".*(abc|bcd|cde|def|efg|fgh|pqr|qrs|rst|stu|tuv|uvw|vwx|wxy|xyz).*") && !password.matches(".*[iol].*")));

            System.out.println(password);
        }
    }

    private static boolean twoPairs(String s) {
        String m0 = null;
        Matcher matcher = Pattern.compile("([a-z])\\1").matcher(s);
        while (matcher.find()) {
            if (m0 != null && !matcher.group(1).equals(m0)) return true;
            m0 = matcher.group(1);
        }
        return false;
    }
}
