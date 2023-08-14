package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    21:33~22:15(42분)

    *BFS*

    0,0 에서 시작해서 치즈 테두리 찾기
 */
public class BOJ_2636_230814 {
    static int[][] map;
    static boolean[][] visited;
    static int n,m;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static boolean stopFlag = false;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n+1][m+1];


        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (!stopFlag) {
            visited = new boolean[n+1][m+1];
            bfs();
        }

        sb.append(String.format("%d\n%d",list.size()-1, list.get(list.size()-2)));
        System.out.println(sb);
    }

    static void bfs() {
        Queue<Location> q = new LinkedList<>();
        q.offer(new Location(1,1));
        visited[1][1] = true;

        while (!q.isEmpty()) {
            Location location = q.poll();
            int x = location.x;
            int y = location.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 치즈 테두리 찾기
                if (isRange(nx,ny) && !visited[nx][ny]) {

                    if (map[nx][ny] == 1) { // 치즈 만남
                        map[nx][ny] = 2;
                        visited[nx][ny] = true;
                    }
                    else if (map[nx][ny] == 0) { // 빈 공간
                        q.offer(new Location(nx,ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        cheeseBorder();
    }

    static void cheeseBorder() {
        int cnt = 0;
        stopFlag = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == 2) {
                    map[i][j] = 0;
                    stopFlag = false;
                    cnt++;

                }
            }
        }

        list.add(cnt);
    }

    static boolean isRange(int nx, int ny) {
        return (nx > 0 && ny > 0 && nx <= n && ny <= m);
    }

    static class Location {
        int x,y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
