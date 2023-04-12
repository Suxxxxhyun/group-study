package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_23083_230412 {
    static int N,M;
    static int K;
    static long[][] dp = new long[1001][1001];
    static final int Mod = 1000000007;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] = -1;
            }
        }

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            dp[x][y] = 0;
        }

        System.out.println(Count(N, M));
    }

    static long Count(int x, int y) {

        if (x < 1 || y < 1 || N < x || M < y) {
            return 0;
        }
        if (x == 1 && y == 1) {
            return 1;
        }

        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        if (y % 2 == 0) {
            dp[x][y] = (Count(x - 1, y) + Count(x, y - 1) + Count(x + 1, y - 1)) % Mod;
        } else {
            dp[x][y] = (Count(x - 1, y) + Count(x - 1, y - 1) + Count(x, y - 1)) % Mod;
        }

        return dp[x][y];
    }
}
