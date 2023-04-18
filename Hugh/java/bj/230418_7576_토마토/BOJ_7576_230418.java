package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576_230418 {
    static int N,M;
    static int[][] graph;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[M + 1][N + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 1) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        while (!q.isEmpty()) {
            int x = q.peek()[0];
            int y = q.peek()[1];
            q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx > 0 && nx <= M && ny > 0 && ny <= N) {
                    if (graph[nx][ny] == 0) {
                        graph[nx][ny] = graph[x][y] + 1;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        int max = Integer.MIN_VALUE;
        if (checkZero()) {
            return -1;
        } else {
            for (int i = 1; i <= M; i++) {
                for (int j = 1; j <= N; j++) {
                    if (max < graph[i][j]) {
                        max = graph[i][j];
                    }
                }
            }
            return max - 1;
        }
    }
    static boolean checkZero() {
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (graph[i][j] == 0) {
                    return true;
                }
            }
        }
        return false;
    }

}
