package BOJ.DP;

import java.io.*;

/*
    dp = 모든 경우의수를 구해주는것
 */
public class BOJ_2839_230714 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];

        if (N >= 3) dp[3] = 1;
        if (N >= 5) dp[5] = 1;

        // 6부터 진행, 나눠 떨어지지 않으면 -1
        for (int i = 6; i <= N; i++) {

            // 더 적은 봉지 사용하기 위해 5부터 mod
            if (i % 5 == 0) dp[i] = dp[i-5] + 1;
            else if (i % 3 == 0) dp[i] = dp[i-3] + 1;
            else {
                // 뭐라도 값이 있다면
                if (dp[i-5] != 0 && dp[i-3] != 0) {
                    dp[i] = Math.min(dp[i-5], dp[i-3]) + 1;
                }
            }
        }

        if (dp[N] == 0) sb.append(-1);
        else sb.append(dp[N]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
