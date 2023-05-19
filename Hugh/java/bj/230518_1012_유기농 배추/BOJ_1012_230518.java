package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1012_230518 {
    static int T;
    static int group_cnt;
    static int[][] arr;
    static boolean[][] visited;
    static int[][] idx = new int[][]{{-1, 0},{0, 1},{1, 0},{0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            arr = new int[M][N];
            visited = new boolean[M][N];
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x][y] = 1;
            }

            group_cnt = 0;
            pre();
            sb.append(group_cnt).append("\n");
        }
        System.out.println(sb);
    }

    static void pre() {
        for (int j = 0; j < arr.length; j++) {
            for (int k = 0; k < arr[j].length; k++) {
                if (!visited[j][k] && arr[j][k] == 1) {
                    group_cnt++;
                    dfs(j, k);

                }
            }
        }
    }

    static void dfs(int x, int y) {
        // visited 체크
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + idx[i][0];
            int ny = y + idx[i][1];

            if (isRange(nx, ny) && arr[nx][ny] == 1 && !visited[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }

    static boolean isRange(int nx, int ny) {
        if (nx >= 0 && ny >= 0 && nx < arr.length && ny < arr[0].length) {
            return true;
        }
        return false;
    }
}
