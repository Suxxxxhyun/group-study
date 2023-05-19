package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1003_230330{
    static StringBuilder sb = new StringBuilder();
    static Integer[][] dp = new Integer[41][2];
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 0과 1일때 호출 횟수
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            Fibo(N);
            sb.append(dp[N][0]).append(" ").append(dp[N][1]).append("\n");
        }

        System.out.println(sb);
    }

    static Integer[] Fibo(int t) {

        if(dp[t][0] == null || dp[t][1] == null) {
            dp[t][0] = Fibo(t - 1)[0] + Fibo(t - 2)[0];
            dp[t][1] = Fibo(t - 1)[1] + Fibo(t - 2)[1];
        }

        return dp[t];
    }
}


