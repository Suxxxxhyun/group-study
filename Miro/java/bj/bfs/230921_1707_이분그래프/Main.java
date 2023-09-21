import java.io.*;
import java.util.*;

/* 이분그래프
- 루프가 있으면, 이분그래프가 아니다.
- 노드가 빨간색(1)이면, 인접한 노드를 다 파란색(-1)으로 칠함
 */

class Main {
    static int node, line;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] color;
    static String ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            node = Integer.parseInt(st.nextToken());
            line = Integer.parseInt(st.nextToken());
            graph = new ArrayList<>();
            color = new int[node+1];
            ans = "YES";

            // graph 초기화
            for (int i = 0; i <= node; i++) {
                graph.add(new ArrayList<>());
            }

            // init
            for (int i = 0; i < line; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            for (int i = 1; i <= node; i++) {
                if (color[i] == 0) {
                    if (!bfs(i)) break;
                }
            }
            System.out.println(ans);
        }
    }

    static Boolean bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        color[start] = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (Integer next : graph.get(cur)) {
                if (color[cur] == color[next]) { // 인접한 곳이 같은 색이면 이분그래프가 아니다}
                    ans = "NO";
                    return false;
                }
                if (color[next] == 0) {
                    color[next] = (color[cur] == 1) ? -1 : 1;
                    queue.offer(next);
                }
            }
        }
        return true;
    }
}