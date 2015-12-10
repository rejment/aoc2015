import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author daniel.rejment@tacton.com (2015-12-10)
 */
public class Day10 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("((\\d)\\2*)");
        String x = "3113322113";
        for (int k = 0; k < 50; k++) {
            StringBuilder sb = new StringBuilder();
            Matcher matcher = pattern.matcher(x);
            int lastEnd = 0;
            while (matcher.find()) {
                sb.append(x.substring(lastEnd, matcher.start()));
                sb.append(matcher.group(1).length()).append(matcher.group(2));
                lastEnd = matcher.end();
            }
            sb.append(x.substring(lastEnd));
            x = sb.toString();
            if (k == 39 || k == 49) {
                System.out.println(x.length());
            }
        }
    }
}
