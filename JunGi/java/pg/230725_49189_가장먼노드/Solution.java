import java.util.*;

/** 2023.07.25 (09:45 ~ 09:59)

입력:
 1. 노드개수 E: 2 ~ 2만
 2. 간선개수 V: 1 ~ 5만
 3. O(E), O(V), log scale
 
목표: 1번 노드로부터 가장 멀리 떨어진 노드 개수 구하기
-> 다익스트라 O(ElogV)
*/
class Solution {
    private List<Edge>[] adj;
    private int[] minCost;
    public int solution(int n, int[][] edge) {
        initAdj(n, edge);
        dijkstra(n);
        int answer = getMaxCount(n);
        return answer;
    }
    
    private int getMaxCount(int n) {
        int max = 0;
        for(int node=2; node<=n; node++) {
            max = Math.max(max, minCost[node]);
        }
        int maxCount = 0;
        for(int node=2; node<=n; node++) {
            if(minCost[node] == max) {
                maxCount ++;
            }
        }
        return maxCount;
    }
    
    private void dijkstra(int n) {
        minCost = new int[n+1];
        Arrays.fill(minCost, 987654321);
        minCost[1] = 0;
        
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Edge(1, 0));
        
        while(!pq.isEmpty()) {
            Edge cur = pq.poll();
            
            for(Edge next: adj[cur.node]) {
                if(cur.cost + next.cost < minCost[next.node]) {
                    minCost[next.node] = cur.cost + next.cost;
                    pq.add(new Edge(next.node, minCost[next.node]));
                }
            }
        }
        // System.out.println(Arrays.toString(minCost));
    }
    
    private void initAdj(int n, int[][] edge) {
        adj = new ArrayList[n+1];
        for(int node=1; node<=n; node++) {
            adj[node] = new ArrayList<>();
        }
        for(int[] e: edge) {
            int from = e[0];
            int to = e[1];
            
            adj[from].add(new Edge(to, 1));
            adj[to].add(new Edge(from, 1));
        }
    }
}

class Edge {
    int node;
    int cost;
    
    public Edge(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}
