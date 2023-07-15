package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    1번 집 색은 2번 집 색과 같지 않아야 한다.
    N번 집색은 N-1번 집 색과 같지 않아야 한다.
    i번의 집 색은 i-1, i+1번의 집 색과 같지 않아야 한다.

    요약) 인접한 집끼리는 색이 겹치면 안된다.

    *DP
 */
public class BOJ_1149_230715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N+1][3]; //R.G.B
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            // 겹치치 않느 최솟값 구해가며 더해줌
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + R;
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + G;
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + B;
        }

        System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));
    }
}
