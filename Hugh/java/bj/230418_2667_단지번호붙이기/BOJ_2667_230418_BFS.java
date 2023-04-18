package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2667_230418_BFS {
    static int N;
    static int[][] graph;
    static boolean[][] visited;
    static ArrayList<Integer> apart = new ArrayList<>();
    static int apartNum = 0, cnt = 0;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(graph[i][j] == 1 && !visited[i][j]) {
                    cnt = 0;
                    apartNum++;
                    bfs(i, j);
                    apart.add(cnt);
                }
            }
        }
        Collections.sort(apart);
        sb.append(apartNum).append("\n");
        for (int i = 0; i < apart.size(); i++) {
            sb.append(apart.get(i)).append("\n");
        }

        System.out.println(sb);
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        cnt++;

        while (!q.isEmpty()) {
            int curX = q.peek()[0];
            int curY = q.peek()[1];
            q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                   if (graph[nx][ny] == 1 && !visited[nx][ny]) {
                       q.offer(new int[]{nx, ny});
                       visited[nx][ny] = true;
                       cnt++;
                   }
                }
            }
        }
    }
}
