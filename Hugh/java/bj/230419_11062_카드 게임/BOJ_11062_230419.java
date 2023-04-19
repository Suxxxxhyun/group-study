package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_11062_230419 {
    static int[] cards;
    static int[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());


        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            cards = new int[N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= N; i++) {
                cards[i] = Integer.parseInt(st.nextToken());
            }

            dp = new int[2][N + 1][N + 1];
            for (int i = 0; i < 2; i++) {
                for (int j = 1; j <= N; j++) {
                    for (int k = 1; k <= N; k++) {
                        dp[i][j][k] = -1;
                    }
                }
            }

            sb.append(recursion(0,1,N) + "\n");
        }

        System.out.println(sb);
    }

    static int recursion(int turn, int start, int end) {
        if (dp[turn][start][end] != -1) {
            return dp[turn][start][end];
        }

        // 기저 사례
        if (start >= end) {
            if (turn == 0) {
                return cards[start];
            } else {
                return 0;
            }
        }

        dp[turn][start][end] = 0;
        if (turn == 0) {
            // 근우
            dp[turn][start][end] = Math.max(recursion(turn + 1, start + 1, end) + cards[start], recursion(turn + 1, start, end - 1) + cards[end]);
        } else {
            // 명우
            dp[turn][start][end] = Math.min(recursion(turn - 1, start + 1, end), recursion(turn - 1, start, end - 1));
        }

        return dp[turn][start][end];
    }
}
