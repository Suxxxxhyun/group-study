package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2814_230520 {
    static int T, N, M;
    static int max;
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new int[N + 1][N + 1];
            visited = new boolean[N + 1];

            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[a][b] = 1;
                arr[b][a] = 1;
            }

            max = 0;
            for (int j = 1; j <= N; j++) {
                dfs(j, 1);
                visited[j] = false;
            }
            sb.append(String.format("#%d %d\n", i, max));
        }
        System.out.println(sb);
    }

    static void dfs(int val, int cnt) {

        visited[val] = true;
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && arr[val][i] == 1) {
                dfs(i, cnt + 1);
                visited[i] = false;
            }
        }
        max = Math.max(max, cnt);
    }
}
