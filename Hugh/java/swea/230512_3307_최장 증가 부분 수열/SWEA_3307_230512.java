package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3307_230512 {
    static int T, N;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            dp = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            dp[0] = 1;
            for (int j = 1; j < N; j++) {
                dp[j] = 1;
                for (int k = 0; k < j; k++) {
                    if (arr[k] < arr[j] && dp[j] <= dp[k]) {
                        dp[j] = dp[k] + 1;
                    }
                }
            }

            int max = Integer.MIN_VALUE;
            for (int val : dp) {
                max = Math.max(max, val);
            }
            sb.append(String.format("#%d %d\n", i, max));
        }
        System.out.println(sb);
    }
}
