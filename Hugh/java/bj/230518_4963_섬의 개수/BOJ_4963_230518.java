package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4963_230518 {
    static int[][] arr;
    static boolean[][] visited;
    static int count;
    static int[][] idx = new int[][]{{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) break;

            arr = new int[h][w];
            visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            count = 0;
            pre();
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
    static void pre() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (!visited[i][j] && arr[i][j] == 1) {
                    dfs(i, j);
                    count++;
                }
            }
        }
    }

    static void dfs(int x, int y) {
        // visited 체크
        visited[x][y] = true;

        for (int i = 0; i < 8; i++) {
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
