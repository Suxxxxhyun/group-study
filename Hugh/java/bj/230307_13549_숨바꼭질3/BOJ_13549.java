package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13549 {
    static int n;
    static int k;

    static int visited[] = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int result = bfs(n);
        System.out.println(result);
    }

    private static int bfs(int node) {
        Queue<Integer> q = new LinkedList<Integer>();

        q.add(node);
        int index = node;
        int n = 0;
        visited[index] = 1;
        while (!q.isEmpty()) {
            n = q.remove();

            if (n == k)
            {
                return visited[n] - 1;
            }
            if(n * 2 <= 100000 && visited[2 * n] == 0)
            {
                visited[2 * n] = visited[n];
                q.add(2 * n);
            }
            if (n - 1 >= 0 && visited[n - 1] == 0)
            {
                visited[n - 1] = visited[n] + 1;
                q.add(n - 1);
            }
            if (n + 1 <= 100000 && visited[n + 1] == 0)
            {
                visited[n + 1] = visited[n] + 1;
                q.add(n + 1);
            }

        }
        return -1;
    }
}
