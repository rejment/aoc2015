/**
 * @author daniel.rejment@tacton.com (2015-12-15)
 */
public class Day15 {
    public static void main(String[] args) {
        int[][] ar = {
                {4, -2, 0, 0, 5},
                {0, 5, -1, 0, 8},
                {-1, 0, 5, 0, 6},
                {0, 0, -2, 2, 1}
        };
        int max = 0;
        for (int a = 1; a < 96; a++) {
            for (int b = 1; b < 100 - a; b++) {
                for (int c = 1; c < 100 - a - b; c++) {
                    int d = 100 - a - b - c;
                    // if (ar[0][4] * a + ar[1][4] * b + ar[2][4] * c + +ar[3][4] * d != 500) continue;
                    int score = 1;
                    for (int i = 0; i < 4; i++) {
                        score *= Math.max(0, ar[0][i] * a + ar[1][i] * b + ar[2][i] * c + ar[3][i] * d);
                    }
                    max = Math.max(score, max);
                }
            }
        }


        System.out.println(max);

    }
}
