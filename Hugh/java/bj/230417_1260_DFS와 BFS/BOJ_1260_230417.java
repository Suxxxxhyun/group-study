package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_230417 {
    static int N,M,V;
    static int[][] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 간선 그리기
            graph[a][b] = graph[b][a] = 1;
        }

        dfs(V);
        sb.append("\n");
        visited = new boolean[N + 1];

        bfs(V);

        System.out.println(sb);


    }

    static void dfs(int start) {
        visited[start] = true;
        sb.append(start + " ");

        for (int i = 0; i <= N; i++) {
            if (graph[start][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    static void bfs(int start) {
        q.add(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            start = q.poll();
            sb.append(start + " ");
            for (int i = 1; i <= N; i++) {
                if (graph[start][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
