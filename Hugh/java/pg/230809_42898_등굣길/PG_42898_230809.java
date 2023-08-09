package Programmers.Lv3;

import java.util.*;

/*
    09:30~

    *DP?*

    마지막 부분에 결과값이 남도록 누적?
    점화식 : dp[i][j] = dp[i-1][j] + dp[i][j-1]
    웅덩이 스킵하고 계속 더해가기
*/
public class PG_42898_230809 {
    // static int[] dx = {-1, 0, 1, 0};
    // static int[] dy = {0, 1, 0, -1};
    // static boolean[][] visited;
    static int[][] dp;
    static int cnt = 0;
    static int mod = 1000000007;

    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;

        dp = new int[n+1][m+1];
        // visited = new boolean[n+1][m+1];

        // 웅덩이 표시
        for (int i = 0; i < puddles.length; i++) {
            dp[puddles[i][1]][puddles[i][0]] = -1;
        }

        dp[1][1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (dp[i][j] == -1) continue;
                if (dp[i-1][j] > 0) dp[i][j] += dp[i-1][j];
                if (dp[i][j-1] > 0) dp[i][j] += dp[i][j-1];

                dp[i][j] %= mod; // mod로 나머지 구하기
            }
        }

        return dp[n][m];
    }

//     private static void dfs(int x, int y, int n, int m) {
//         // 종료 조건
//         if (x == n && y == m) {
//             cnt++;
//             cnt %= mod;
//             return;
//         }

//         visited[x][y] = true; // 방문 처리
//         for (int k = 0; k < 4; k++) {
//             int nx = x + dx[k];
//             int ny = y + dy[k];

//             if (isRange(nx,ny, n, m) && arr[nx][ny] != -1 && !visited[nx][ny]) {
//                 dfs(nx, ny, n, m);

//             }
//         }

//     }

//     private static boolean isRange(int nx, int ny, int n, int m) {
//         return (nx >= 0 && ny >= 0 && nx < n && ny < m);
//     }
}
