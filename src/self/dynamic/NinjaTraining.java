package self.dynamic;

import java.util.*;

public class NinjaTraining {

    public static int ninjaTraining(int n, int[][] points) {
        int[][] dp = new int[n][4];

        for (int[] row: dp)
            Arrays.fill(row, -1);

        return ninjaPoints(n - 1, 3, points, dp);
    }

    public static int ninjaPoints(int day, int last, int[][] points, int[][] dp) {
        if (dp[day][last] != -1) return dp[day][last];

        if (day == 0) {
            int max = 0;
            for (int i = 0; i < 3; i++) {
                if (i != last)
                    max = Math.max(points[day][i], max);
            }
            return dp[day][last] = max;
        }

        int max = 0;

        for (int i = 0; i < 3; i++) {
            if (i != last) {
                int activity = points[day][i] + ninjaPoints(day - 1, i, points, dp);
                max = Math.max(activity, max);
            }
        }

        return dp[day][last] = max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] points = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                points[i][j] = in.nextInt();
            }
        }
        System.out.println(ninjaTraining(n, points));
    }
}
