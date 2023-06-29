package BOJ.Graph;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_17070_230629 {
    static int n;
    static int cnt = 0;
    static int[][] graph;

    /**
     *  DFS 풀이?
     *  갈 수 있는 방향은 3군데
     *
     *  시작칸은 1
     *
     *  파이프 이동방향
     *  가로 -> 동쪽, 대각선
     *  세로 -> 남쪽, 대각선
     *  대각선 -> 동쪽, 남쪽 방향 대각선
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        graph = new int[n+1][n+1];

        // 그래프 만들기 (1 부터 시작)
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(1,2,0);

        sb.append(cnt);
        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }

    /**
     *  direction 0 = 가로
     *  direction 1 = 세로
     *  direction 2 = 대각선
     *
     *  이동한 뒷부분은 신경쓰지마
     */
    static void dfs(int x, int y, int direction) {
        // n * n 도착
        if (x == n && y == n && graph[x][y] == 0) {
            cnt++;
            return;
        }

        // 가로
        if (direction == 0) {
            // 동쪽 이동
            // 확인할 곳 1군데
            if (isRange(x, y+1) && graph[x][y+1] == 0) dfs(x, y+1, 0);

            // 오른쪽 아래 대각선 이동
            // 확인할 곳 3군데
            if (isRange(x+1, y+1) && graph[x+1][y+1] == 0 && graph[x][y+1] == 0 && graph[x+1][y] == 0) dfs(x+1, y+1, 2);
        }

        // 세로
        else if (direction == 1) {
            // 남쪽 이동
            if (isRange(x+1, y) && graph[x+1][y] == 0) dfs(x+1, y, 1);

            // 오른쪽 아래 대각선 이동
            if (isRange(x+1, y+1) && graph[x+1][y+1] == 0 && graph[x][y+1] == 0 && graph[x+1][y] == 0) dfs(x+1, y+1, 2);

        }

        // 대각선
        else if (direction == 2) {

            // 동쪽 이동 (가로 변환)
            if (isRange(x, y+1) && graph[x][y+1] == 0) dfs(x, y+1, 0);

            // 남쪽 이동 (세로 변환)
            if (isRange(x+1, y) && graph[x+1][y] == 0) dfs(x+1, y, 1);

            // 오른쪽 아래 대각선 이동
            if (isRange(x+1, y+1) && graph[x+1][y+1] == 0 && graph[x][y+1] == 0 && graph[x+1][y] == 0) dfs(x+1, y+1, 2);

        }

    }

    // 범위 확인
    static boolean isRange(int x, int y) {
        return (x >= 1 && y >= 1 && x <= n && y <= n);
    }
}
