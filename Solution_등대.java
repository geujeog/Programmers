import java.util.*;

public class Solution_등대 {
    static List<Integer>[] light;

    public int solution(int n, int[][] lighthouse) {
        toGraph(n, lighthouse);

        boolean[] check = new boolean[n+1];
        int[][] dp = new int[n+1][2];

        on(dp, check, 1);

        int result = Math.min(dp[1][0], dp[1][1]);

        return result;
    }

    public void on (int[][] dp, boolean[] check, int idx) {
        dp[idx][0] = 0;
        dp[idx][1] = 1;

        check[idx]  = true;

        int result = 0;

        for (Integer i : light[idx]) {
            if (check[i]) continue;

            on(dp, check, i);

            dp[idx][0] += dp[i][1];
            dp[idx][1] += Math.min(dp[i][0], dp[i][1]);
        }
    }

    public void toGraph (int n, int[][] lighthouse) {
        light = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            light[i] = new ArrayList<>();
        }

        for (int i = 0; i < lighthouse.length; i++) {
            int a = lighthouse[i][0];
            int b = lighthouse[i][1];

            light[a].add(b);
            light[b].add(a);
        }
    }
}