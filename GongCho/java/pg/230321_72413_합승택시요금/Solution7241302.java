package Level3;

import java.util.*;

//다익스트라 사용
class Solution7241302 {

    ArrayList<Node>[] graph;
    int[] d;
    int[] startA;
    int[] startB;
    static final int INF = Integer.MAX_VALUE;
    int answer = 0;
    class Node implements Comparable<Node>{
        int index, distance;

        public Node(int index, int distance){
            this.index = index;
            this.distance = distance;
        }

        public int compareTo(Node other){
            return this.distance - other.distance;
        }
    }

    public int solution(int n, int s, int a, int b, int[][] fares) {

        graph = new ArrayList[n+1];
        d = new int[n+1];
        startA = new int[n+1];
        startB = new int[n+1];
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<Node>();
        }

        for(int i=0; i<fares.length; i++){
            int start = fares[i][0];
            int end = fares[i][1];
            int cost = fares[i][2];
            graph[start].add(new Node(end,cost));
            graph[end].add(new Node(start,cost));
        }

        Arrays.fill(d, INF);
        Arrays.fill(startA, INF);
        Arrays.fill(startB, INF);

        dijstra(s, d);
        dijstra(a, startA);
        dijstra(b, startB);

        answer = d[a] + d[b];
        for(int i=1; i<=n; i++){
            answer = Math.min(answer, d[i] + startA[i] + startB[i]);
        }

        return answer;
    }

    public void dijstra(int s, int[] d){
        d[s] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.offer(new Node(s,0));
        while(!pq.isEmpty()){
            Node node = pq.poll();
            int now = node.index;
            int dist = node.distance;

            if(dist > d[now]){
                continue;
            }

            for(int i=0; i<graph[now].size(); i++){
                int cost = graph[now].get(i).distance + d[now];
                if(cost < d[graph[now].get(i).index]){
                    d[graph[now].get(i).index] = cost;
                    pq.offer(new Node(graph[now].get(i).index, cost));
                }
            }
        }
    }
}
