/**
 * @author daniel.rejment@tacton.com (2015-12-21)
 */
public class Day21 {
    public static void main(String[] args) {
        int[][] weapons = {
                {8, 4, 0},
                {10, 5, 0},
                {25, 6, 0},
                {40, 7, 0},
                {74, 8, 0},
        };

        int[][] armors = {
                {0, 0, 0},
                {13, 0, 1},
                {31, 0, 2},
                {53, 0, 3},
                {75, 0, 4},
                {102, 0, 5},
        };

        int[][] rings = {
                {0, 0, 0},
                {25, 1, 0},
                {50, 2, 0},
                {100, 3, 0},
                {20, 0, 1},
                {40, 0, 2},
                {80, 0, 3},
        };

        int min = 500;
        int max = 0;
        for (int[] w : weapons) {
            for (int[] a : armors) {
                for (int[] r1 : rings) {
                    for (int[] r2 : rings) {
                        if (r1[0] != 0 && r1 == r2) continue;

                        int[] boss = {103, 9, 2};
                        int[] player = {100, w[1] + a[1] + r1[1] + r2[1], w[2] + a[2] + r1[2] + r2[2]};
                        int cost = w[0] + a[0] + r1[0] + r2[0];

                        if (simulate(boss, player)) {
                            min = Math.min(min, cost);
                        } else {
                            max = Math.max(max, cost);
                        }
                    }
                }
            }
        }

        System.out.println(min);
        System.out.println(max);
    }

    private static boolean simulate(int[] boss, int[] player) {
        for (; ; ) {
            boss[0] -= Math.max(1, player[1] - boss[2]);
            if (boss[0] <= 0) return true;
            player[0] -= Math.max(1, boss[1] - player[2]);
            if (player[0] <= 0) return false;
        }
    }
}
