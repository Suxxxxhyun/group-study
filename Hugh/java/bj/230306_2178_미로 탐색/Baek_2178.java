import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_2178 {
    static int[][] map;
    static int A;
    static int B;
    static boolean[][] visited;
    static int[] dx = { -1, 1, 0, 0};
    static int[] dy = { 0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        map = new int[A][B];
        for (int i = 0; i < A; i++){
            String M = br.readLine();
            for (int j = 0; j < B; j++){
                map[i][j] = M.charAt(j) - '0';
            }
        }
        visited = new boolean[A][B];
        visited[0][0] = true;
        bfs(0, 0);
        System.out.println(map[A-1][B-1]);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x,y});
        while (!q.isEmpty()){
            int now[] = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++){
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= A || nextY >= B)
                    continue;
                if (visited[nextX][nextY] || map[nextX][nextY] == 0)
                    continue;

                q.add(new int[] {nextX, nextY});
                map[nextX][nextY] = map[nowX][nowY] + 1;
                visited[nextX][nextY] = true;
            }
        }
    }
}
