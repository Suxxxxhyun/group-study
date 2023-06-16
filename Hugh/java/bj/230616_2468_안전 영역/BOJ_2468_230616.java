package BOJ.Greedy;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2468_230616 {
    static int N;
    static boolean[][] visited;
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        int maxHeight = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] > maxHeight) {
                    maxHeight = arr[i][j];
                }
            }
        }

        int max = 0;
        // 1. 모든 지역 탐색
        for (int h = 0; h <= maxHeight; h++) {
            visited = new boolean[N][N];
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 2. 안전 영역 탐지
                    if (!visited[i][j] && arr[i][j] > h) {
                        cnt += dfs(i, j, h);
                    }
                }
            }
            max = Math.max(max, cnt);
        }
        sb.append(max);
        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }

    // 안전 영역 DFS 탐색
    static int dfs(int x, int y, int height) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx > N - 1 || ny > N - 1) continue;
            if (visited[nx][ny]) continue;
            if (arr[nx][ny] > height) {
                dfs(nx, ny, height);
            }
        }
        return 1;
    }
}
