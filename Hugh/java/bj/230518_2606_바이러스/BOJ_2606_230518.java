package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2606_230518 {
    static int N, M;
    static int cnt;
    static boolean[] visited;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        arr = new int[N][N];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        pre();
        sb.append(cnt - 1);
        System.out.println(sb);
    }

    static void pre() {
        for (int i = 0; i < N; i++) {
            if (i == 0 && !visited[i]) {
                cnt = 0;
                dfs(i);
            }
        }
    }

    static void dfs(int val) {
        if (visited[val]) {
            return;
        }
        cnt++;
        visited[val] = true;
        for (int i = 0; i < N; i++) {
            if (arr[val][i] == 1) {
                dfs(i);
            }
        }
    }
}
