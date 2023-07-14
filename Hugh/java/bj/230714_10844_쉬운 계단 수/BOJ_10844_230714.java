package BOJ.DP;

import java.io.*;

/*
    15:05~
    정답을 10억으로 나눈 나머지
    N = 1~100

    dp[i][j]
    i = 자릿수
    j = 자릿값

    계단수가 총 몇개인지
    (매번 구해보자)

    45656 기준 자릿수 1,2,3,4,5
    점화식 : dp[4][3] = dp[3][2] + dp[3][4]
    * 자릿값 0일 경우 = dp[i-1][1]
    * 자릿값 9일 경우 = dp[i-1][8]

    경우의 수 구하기
    1 -> 0,1,1,1,1,1,1,1,1,1
    2 -> 1,1,2,2,2,2,2,2,2,1
    3 -> 1,3,3,4,4,4,4,4,3,2
    ...
 */
public class BOJ_10844_230714 {
    static long mod = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        // 0~9
        long[][] dp = new long[N+1][10];

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {

            // 자릿수 탐색
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    dp[i][0] = dp[i-1][1] % mod;
                } else if (j == 9) {
                    dp[i][9] = dp[i-1][8] % mod;
                } else {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1] % mod;
                }
            }
        }

        long result = 0;
        for (int i = 0; i < 10; i++) {
            result += dp[N][i];
        }

        sb.append(result % mod);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
