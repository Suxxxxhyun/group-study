package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_13732_230515 {
    static int T, N;
    static boolean result;
    static boolean firstV;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, -1, 0, 1}, dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            N = Integer.parseInt(br.readLine());

            arr = new char[N][N];
            for (int j = 0; j < N; j++) {
                arr[j] = br.readLine().toCharArray();
            }

            visited = new boolean[N][N];
            result = true;
            firstV = false;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (firstV && !visited[j][k] && arr[j][k] == '#') {
                        result = false;
                        break;
                    }
                    if (!firstV && !visited[j][k] && arr[j][k] == '#') {
                        result = bfs(j, k, visited);
                        firstV = true;
                    }
                }
                if (!result) break;
            }
            sb.append(String.format("#%d %s\n", i, result == true ? "yes" : "no"));
        }
        System.out.println(sb);
    }

    static boolean bfs(int x, int y, boolean[][] visited) {
        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(x, y));
        visited[x][y] = true;

        Node result = q.peek();
        int sCnt = 1;

        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.x > result.x && node.y > result.y) result = node;
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (isRange(nx, ny) && arr[nx][ny] == '#' && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    sCnt++;
                    q.offer(new Node(nx, ny));
                }
            }
        }
        return ((result.x - x + 1) * (result.y - y + 1)) == sCnt;
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean isRange(int nx, int ny) {
        if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
            return true;
        }
        return false;
    }
}
