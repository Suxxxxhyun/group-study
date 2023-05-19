package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11725_230518 {
    static int N;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        parents = new int[N];
        list = new ArrayList[N];

        // 2차원 list 초기화
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            list[x].add(y);
            list[y].add(x);
        }

        pre();

        for (int i = 1; i < N; i++) {
            sb.append(parents[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void pre() {
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }
    static void dfs(int val) {
        if (visited[val]) {
            return;
        }

        // visited 체크
        visited[val] = true;

        for (int vertex : list[val]) {
            dfs(vertex);
            parents[vertex] = val + 1;
        }
    }
}
