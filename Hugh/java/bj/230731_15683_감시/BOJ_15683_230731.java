package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15683_230731 {
    static int n;
    static int m;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static ArrayList<CCTV> list = new ArrayList<>();
    static int min = Integer.MAX_VALUE;
    static class CCTV {
        int x;
        int y;
        int num;

        CCTV(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());

                if (graph[i][j] != 0 && graph[i][j] != 6) {
                    list.add(new CCTV(i, j, graph[i][j]));
                }
            }
        }
        dfs(0, graph);
        System.out.println(min);
    }

    // 모든 경우의 수 검사
    static void dfs(int cnt, int[][] graph) {
        if (cnt == list.size()) {
            min = Math.min(min, CheckZero(graph));
            return;
        }

        int num = list.get(cnt).num;
        int x = list.get(cnt).x;
        int y = list.get(cnt).y;
        int[][] tmp; // graph 깊은복사

        if (num == 1) {
            tmp = copyGraph(graph);
            east(tmp, x, y);
            dfs(cnt+1, tmp);

            tmp = copyGraph(graph);
            west(tmp, x, y);
            dfs(cnt+1, tmp);

            tmp = copyGraph(graph);
            south(tmp, x, y);
            dfs(cnt+1, tmp);

            tmp = copyGraph(graph);
            north(tmp, x, y);
            dfs(cnt+1, tmp);
        } else if (num == 2) {
            tmp = copyGraph(graph);
            east(tmp, x, y);
            west(tmp, x, y);
            dfs(cnt+1, tmp);

            tmp = copyGraph(graph);
            south(tmp, x, y);
            north(tmp, x, y);
            dfs(cnt+1, tmp);
        } else if (num == 3) {
            tmp = copyGraph(graph);
            north(tmp, x, y);
            east(tmp, x, y);
            dfs(cnt+1, tmp);

            tmp = copyGraph(graph);
            east(tmp, x, y);
            south(tmp, x, y);
            dfs(cnt+1, tmp);

            tmp = copyGraph(graph);
            south(tmp, x, y);
            west(tmp, x, y);
            dfs(cnt+1, tmp);

            tmp = copyGraph(graph);
            west(tmp, x, y);
            north(tmp, x, y);
            dfs(cnt+1, tmp);
        } else if (num == 4) {
            tmp = copyGraph(graph);
            north(tmp, x, y);
            west(tmp, x, y);
            east(tmp, x, y);
            dfs(cnt+1, tmp);

            tmp = copyGraph(graph);
            north(tmp, x, y);
            east(tmp, x, y);
            south(tmp, x, y);
            dfs(cnt+1, tmp);

            tmp = copyGraph(graph);
            south(tmp, x, y);
            east(tmp, x, y);
            west(tmp, x, y);
            dfs(cnt+1, tmp);

            tmp = copyGraph(graph);
            north(tmp, x, y);
            south(tmp, x, y);
            west(tmp, x, y);
            dfs(cnt+1, tmp);
        } else if (num == 5) {
            tmp = copyGraph(graph);
            east(tmp, x, y);
            west(tmp, x, y);
            south(tmp, x, y);
            north(tmp, x, y);
            dfs(cnt+1, tmp);
        }
    }

    // 동쪽체크
    static void east(int[][] graph, int x, int y) {
        for (int i = y+1; i < m; i++) {
            if (graph[x][i] == 6) return;
            if (graph[x][i] != 0) continue;
            graph[x][i] = -1;
        }
    }
    // 서쪽체크
    static void west(int[][] graph, int x, int y) {
        for (int i = y-1; i >= 0; i--) {
            if (graph[x][i] == 6) return;
            if (graph[x][i] != 0) continue;
            graph[x][i] = -1;
        }
    }
    // 남쪽체크
    static void south(int[][] graph, int x, int y) {
        for (int i = x+1; i < n; i++) {
            if (graph[i][y] == 6) return;
            if (graph[i][y] != 0) continue;
            graph[i][y] = -1;
        }
    }
    // 북쪽체크
    static void north(int[][] graph, int x, int y) {
        for (int i = x-1; i >= 0; i--) {
            if (graph[i][y] == 6) return;
            if (graph[i][y] != 0) continue;
            graph[i][y] = -1;
        }
    }

    static int[][] copyGraph(int[][] graph) {
        int[][] tmp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tmp[i][j] = graph[i][j];
            }
        }
        return tmp;
    }

    static int CheckZero(int[][] graph) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0) {
                    sum++;
                }
            }
        }
        return sum;
    }

}
