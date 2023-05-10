package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1493_230510 {
    static int T, p, q;
    static int[][] dp = new int[301][301];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // --- 값 구해서 저장
        int val = 1;
        for (int i = 1; i < 301; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i - j + 1][j] = val++;
            }
        }
        // ---

        T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            p = Integer.parseInt(st.nextToken());
            q = Integer.parseInt(st.nextToken());

            // p q 좌표 초기화
            int x1 = 0;
            int y1 = 0;
            int x2 = 0;
            int y2 = 0;

            // 좌표 찾기
            for (int j = 1; j < 301; j++) {
                for (int k = 1; k < 301; k++) {
                    if (dp[j][k] == p) {
                        x1 = j;
                        y1 = k;
                    }

                    if (dp[j][k] == q) {
                        x2 = j;
                        y2 = k;
                    }
                }
            }

            // 출력
            sb.append(String.format("#%d %d\n", i, dp[x1 + x2][y1 + y2]));
        }
        System.out.println(sb);
    }
}
