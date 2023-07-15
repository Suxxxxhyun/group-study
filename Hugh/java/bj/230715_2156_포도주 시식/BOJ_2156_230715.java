package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    조건이 주어지면 DP다?
 */
public class BOJ_2156_230715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        int[] arr = new int[N+1];

        // 포도주 배열 담기
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // arr = 6, 10, 13, 9, 8, 1

        for (int i = 1; i <= N; i++) {
            if (i == 1) {
                dp[1] = arr[1]; // OXXXXX
                continue;
            } if (i == 2) {
                dp[2] = arr[1] + arr[2]; // OOXXXX
                continue;
            } if (i == 3) {
                dp[3] = Math.max(dp[2], Math.max(arr[1] + arr[3], arr[2] + arr[3]));  // XOOXXX
                continue;
            }

            dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + arr[i], dp[i-3] + arr[i-1] + arr[i]));
        }

        System.out.println(dp[N]);
    }
}
