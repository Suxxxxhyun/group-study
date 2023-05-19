package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_230519 {
    static int N, M, V;
    static int[][] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        dfs(V);
        visited = new boolean[N+1];
        sb.append("\n");
        bfs(V);
        System.out.println(sb);
    }

    static void dfs(int val) {
        if (visited[val]) {
            return;
        }
        sb.append(val + " ");
        visited[val] = true;
        for (int i = 1; i <= N; i++) {
            if (arr[val][i] == 1) {
                dfs(i);
            }
        }
    }

    static void bfs(int val) {
        Queue<Integer> q = new LinkedList<>();
        q.add(val);
        visited[val] = true;

        while (!q.isEmpty()) {
            int x = q.poll();

            sb.append(x + " ");
            for (int i = 1; i <= N; i++) {
                if (!visited[i] && arr[x][i] == 1) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
