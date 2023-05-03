package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1260_230502 {
    static int N, M, V;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(list[i]);
        }

        dfs(V);
        sb.append("\n");
        visited = new boolean[N + 1];
        bfs(V);

        System.out.println(sb);
    }

    static void dfs (int x) {
        sb.append(x + " ");
        visited[x] = true;

        for (int j = 0; j < list[x].size(); j++) {
            if (visited[list[x].get(j)]) {
                continue;
            }
            dfs(list[x].get(j));
        }
    }

    static void bfs (int start) {
        Queue<Integer> que = new LinkedList<>();

        que.add(start);
        visited[start] = true;

        while (!que.isEmpty()) {
            int x = que.poll();
            sb.append(x + " ");

            for (int i = 0; i < list[x].size(); i++) {
                if (visited[list[x].get(i)]) {
                    continue;
                }
                que.add(list[x].get(i));
                visited[list[x].get(i)] = true;
            }
        }
    }
}

