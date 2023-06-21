import java.util.*;

public class Solution_GPS {
    static List<Integer>[] map;

    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        int answer = 0;

        map = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
            map[i].add(i);
        }

        for (int i = 0; i < m; i++) {
            int a = edge_list[i][0];
            int b = edge_list[i][1];

            map[a].add(b);
            map[b].add(a);
        }

        Integer[][] dp = new Integer[k][n+1]; // gps_log 인덱스에 있는 gps_log 값
        dp[0][gps_log[0]] = 0;

        for (int i = 0; i < k-1; i++) {
            for (int j = 1; j <= n; j++) {
                if (dp[i][j] == null) continue;

                for (Integer next : map[j]) { // 현재 위치에 연결된 값들

                    if (next == gps_log[i+1]) {
                        if (dp[i+1][next] == null) dp[i+1][next] = dp[i][j];
                        else dp[i+1][next] = Math.min(dp[i+1][next], dp[i][j]);
                    }
                    else {
                        if (dp[i+1][next] == null) dp[i+1][next] = dp[i][j]+1;
                        else dp[i+1][next] = Math.min(dp[i+1][next], dp[i][j]+1);
                    }
                }
            }
        }

        return dp[k-1][gps_log[k-1]] == null ? -1 : dp[k-1][gps_log[k-1]];
    }
}
