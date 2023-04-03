package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753_230403 {
    static int V, E, K;
    static ArrayList<ArrayList<Node>> graph;
    static int[] dist;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        graph = new ArrayList<ArrayList<Node>>();

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<Node>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Node(e, w));
        }

        dist = new int[V + 1];

        for (int i = 0; i <= V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Node> queue = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        queue.offer(new Node(K, 0));
        dist[K] = 0;

        while(!queue.isEmpty()) {
            Node temp = queue.poll();

            if (dist[temp.idx] < temp.cost) {
                continue;
            }

            for (int i = 0; i < graph.get(temp.idx).size(); i++) {
                Node nextNode = graph.get(temp.idx).get(i);
                if (dist[nextNode.idx] > temp.cost + nextNode.cost) {
                    dist[nextNode.idx] = temp.cost + nextNode.cost;
                    queue.offer(new Node(nextNode.idx, dist[nextNode.idx]));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }

        System.out.println(sb);
    }

    static class Node {
        int idx, cost;
        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
}
