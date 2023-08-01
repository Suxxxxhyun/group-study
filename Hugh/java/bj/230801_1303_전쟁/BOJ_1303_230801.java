package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    09:50~10:35
    dfs로 뭉쳐있는 W,B 개수 구하기
    n,m 위치 착각;
 */
public class BOJ_1303_230801 {
    static int n;
    static int m;
    static int cnt;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[m][n];
        arr = new char[m][n];
        for (int i = 0; i < m; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        int sumW = 0;
        int sumB = 0;
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (arr[x][y] == 'W' && !visited[x][y]) {
                    cnt = 0;
                    dfs(x, y, 'W');
                    sumW += (int)Math.pow(cnt, 2);
                } else if (arr[x][y] == 'B' && !visited[x][y]) {
                    cnt = 0;
                    dfs(x, y, 'B');
                    sumB += (int)Math.pow(cnt, 2);
                }
            }
        }

        System.out.println(String.format("%d %d", sumW, sumB));
    }

    static void dfs(int x, int y, char soldier) {

        visited[x][y] = true;
        cnt++;
        for (int  i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isRange(nx, ny) && arr[nx][ny] == soldier && !visited[nx][ny]) {
                dfs(nx, ny, soldier);
            }
        }
    }
    static boolean isRange(int nx, int ny) {
        return (nx >= 0 && ny >= 0 && nx < m && ny < n);
    }
}
