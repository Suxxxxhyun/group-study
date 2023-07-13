package BOJ.DP;

import java.io.*;
import java.util.StringTokenizer;

/*
    DP 문제라는데,, 점화식이 뭘까
    어떻게 해야할까,,

    20이하?
 */
public class BOJ_5557_230713 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        // 0 이상 20 이하의 모든 수를 넣자?
        int[] arr = new int[N];
        // 출력값 2^63 - 1
        long[][] dp = new long[N][21];


        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0][arr[0]] = 1;

        int plus; // + 경우
        int minus; // - 경우
        for (int i = 1; i < N-1; i++) {
            for (int j = 0; j <= 20; j++) {
                if (dp[i-1][j] != 0) {
                    plus = j + arr[i];
                    minus = j - arr[i];
                    if (plus >= 0 && plus <= 20) dp[i][plus] += dp[i-1][j];
                    if (minus >= 0 && minus <= 20) dp[i][minus] += dp[i-1][j];
                }
            }
        }


        sb.append(dp[N-2][arr[N-1]]);

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }
}
