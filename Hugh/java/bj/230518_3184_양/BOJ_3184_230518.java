package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3184_230518 {
    static int R, C, O, V;
    static int cntO, cntV;
    static String[] arr;
    static boolean[][] visited;
    static int[][] idx = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new String[R];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            arr[i] = br.readLine();
        }

        pre();
        sb.append(String.format("%d %d\n", O, V));
        System.out.println(sb);
    }

    static void pre() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i].charAt(j) != '#' && !visited[i][j]) {
                    cntO = cntV = 0;
                    // 탐색해!
                    dfs(i, j);

                    if (cntO > cntV) O += cntO;
                    else V += cntV;
                }
            }
        }
    }

    static void dfs(int x, int y) {

        // 양 체크
        if (arr[x].charAt(y) == 'o') cntO++;
        // 늑대 체크
        if (arr[x].charAt(y) == 'v') cntV++;
        // visited 체크
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + idx[i][0];
            int ny = y + idx[i][1];

            if (isRange(nx, ny) && !visited[nx][ny] && arr[nx].charAt(ny) != '#') {
                dfs(nx, ny);
            }
        }
    }

    static boolean isRange(int nx, int ny) {
        if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
            return true;
        }
        return false;
    }
}
