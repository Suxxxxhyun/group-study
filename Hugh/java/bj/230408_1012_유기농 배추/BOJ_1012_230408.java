package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1012_230408 {
    static int M,N,K;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx = { 0, -1, 0, 1};
    static int[] dy = { 1, 0, -1, 0};

    static void dfs(int x, int y) {
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if (cx >= 0 && cy >= 0 && cx < M && cy < N) {
                if (!visit[cx][cy] && arr[cx][cy] == 1) {
                    dfs(cx, cy);
                }
            }
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int cnt = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = new int[M][N];
            visit = new boolean[M][N];

            while (K-- > 0) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                arr[X][Y] = 1;
            }

            for (int x = 0; x < M; x++) {
                for (int y = 0; y < N; y++) {
                    if (arr[x][y] == 1 && !visit[x][y]) {
                        dfs(x, y);
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}
