package Programmers.Lv2;

/*
    2 = 3
    4 = 11
*/
public class PG_12902_230727 {
    static long mod = 1000000007;
    public long solution(int n) {
        int answer = 0;
        long[] dp = new long[n+1];

        dp[2] = 3;
        dp[4] = 11;

        for (int i = 6; i <= n; i+=2) {
            dp[i] = dp[i-2] * 3 + 2;

            for (int j = i-4; j >= 2; j-=2) {
                dp[i] += dp[j] * 2;
            }

            dp[i] %= mod;
        }
        return dp[n];
    }
}

