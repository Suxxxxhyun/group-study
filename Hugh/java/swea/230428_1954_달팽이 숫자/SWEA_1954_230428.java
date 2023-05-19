package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1954_230428 {
    static int T;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];

            int idx = 0;
            int x = 0, y = 0;
            for (int j = 1; j <= n * n; j++) {
                arr[x][y] = j;
                if (x + dx[idx] >= n || x + dx[idx] < 0 || y + dy[idx] >= n || y + dy[idx] < 0 || arr[x + dx[idx]][y + dy[idx]] != 0) {
                    idx = (idx + 1) % 4;
                }
                x += dx[idx];
                y += dy[idx];
            }

            sb.append(String.format("#%d\n", i));
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    sb.append(arr[j][k] + " ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
