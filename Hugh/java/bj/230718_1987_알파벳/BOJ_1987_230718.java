package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1987_230718 {
    static int[] dx = new int[]{0,1,0,-1};
    static int[] dy = new int[]{1,0,-1,0};
    static boolean[] visited = new boolean[26];
    static int[][] graph;
    static int max = Integer.MIN_VALUE;
    static int R, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new int[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                graph[i][j] = str.charAt(j) - 'A';
            }
        }

        dfs(0,0,0);

        System.out.println(max);
    }

    // DFS 진행
    static void dfs(int x, int y, int cnt) {
        if (visited[graph[x][y]]) {
            max = Math.max(max, cnt);
            return;
        }

        visited[graph[x][y]] = true;

        // 상하좌우 체크
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isRange(nx,ny)) {
                dfs(nx,ny,cnt+1);
            }
        }

        // 다음 경우의 수 체크를 위한 반환
        visited[graph[x][y]] = false;

    }

    // 범위 체크
    static boolean isRange(int nx, int ny) {
        return (nx >= 0 && ny >= 0 && nx < R && ny < C);
    }
}
