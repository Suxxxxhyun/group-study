package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11403_230518 {
    static int N;
    static int[][] arr;
    static boolean[] visited;
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        pre();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void pre() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i] && arr[i][j] == 1) {
                    dfs(j);

                    // 큐에 담아온 주소에 1 할당.
                    while (!q.isEmpty()) {
                        arr[i][q.poll()] = 1;
                    }

                    // 줄당 visit 갱신
                    visited = new boolean[N];
                }
            }
        }
    }

    static void dfs(int val) {
        if (visited[val]) {
            return;
        }

        visited[val] = true;
        for (int i = 0; i < N; i++) {
            if (arr[val][i] == 1) {
                // 1인 주소 큐에 담음
                q.add(i);
                dfs(i);
            }
        }

    }
}
