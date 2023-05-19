package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1463_230330 {
    static Integer[] dp;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new Integer[N + 1];
        dp[0] = dp[1] = 0;

        System.out.println(divSub(N));

    }

    static int divSub(int N) {
        if (dp[N] == null) {
            if (N % 6 == 0) {
                dp[N] = Math.min(divSub(N - 1), Math.min(divSub(N / 3), divSub(N / 2))) + 1;
            } else if (N % 3 == 0) {
                dp[N] = Math.min(divSub(N / 3), divSub(N - 1)) + 1;
            } else if (N % 2 == 0) {
                dp[N] = Math.min(divSub(N / 2), divSub(N - 1)) + 1;
            } else {
                dp[N] = divSub(N - 1) + 1;
            }
        }
        return dp[N];
    }
}
