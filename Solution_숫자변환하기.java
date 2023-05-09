import java.util.*;

class Solution_숫자변환하기 {

    public int solution(int x, int y, int n) {
        Integer[] dp = new Integer[y+1];
        dp[x] = 0;

        for (int i = x; i <= y; i++) {
            if (dp[i] == null) continue;

            if (i + n <= y) {
                if (dp[i+n] == null) dp[i+n] = dp[i] + 1;
                else dp[i+n] = Math.min(dp[i+n], dp[i]+1);
            }
            if (i * 2 <= y) {
                if (dp[i*2] == null) dp[i*2] = dp[i] + 1;
                else dp[i*2] = Math.min(dp[i*2], dp[i]+1);
            }
            if (i * 3 <= y) {
                if (dp[i*3] == null) dp[i*3] = dp[i] + 1;
                else dp[i*3] = Math.min(dp[i*3], dp[i]+1);
            }
        }

        if (dp[y] == null) return -1;

        return dp[y];
    }
}