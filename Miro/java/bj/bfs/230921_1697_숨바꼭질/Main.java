import java.io.*;
import java.util.*;

class Main {
    static int N, K;
    static int[] dx = {-1, 1, N};
    static int[] visited = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        if (N == K)     // ***** 처음부터 N==K 일때 처리
            System.out.println(0);
        else
            bfs();
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        visited[N] = 1;
        while (!queue.isEmpty()) {
            int cur = queue.poll(); // 현재 위치
            dx[2] = cur;
            for (int i = 0; i < 3; i++) {
                int next = cur + dx[i]; // 다음 위치
                if (next == K) {    // 정답이면, return
                    System.out.println(visited[cur]);
                    return;
                }
                if (next < 0 || next > 100000 || visited[next] != 0) continue;
                queue.offer(next);
                visited[next] = visited[cur] + 1;
            }

        }
    }
}
