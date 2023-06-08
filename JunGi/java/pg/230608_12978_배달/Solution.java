import java.util.*;
/*
2023.06.08 22m solve (설계:8분, 구현:14분, adj초기화 부분에 디버깅에 시간 소요)

Goal: 음식 주문을 받을 수 있는 마을의 개수 구하기
사실1. 양방향 양의 가중치 그래프
사실2. 1번 노드 -> 모든 노드 최단거리
=> 다익스트라 문제

[다익스트라 설계]
1. minCost[i] = start -> i노드 최단비용
2. Node: 노드번호, Cost
3. 인접하는 노드를 순회하며 최단 비용이 갱신되면 갱신하고 
PQ에 넣으면서 최단비용 순서대로 한번씩 방문하는 알고리즘  --> 그대로 구현

*/
class Solution {
    private int[] minCost;
    private List<Node>[] adj;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        initialAdj(N, road);
        dijkstra(N);
        return getAnswer(K);
    }
    
    private int getAnswer(int K) {
        int count = 0;
        for(int node=1; node<minCost.length; node++) {
            if(minCost[node] <= K) { count++; }
        }
        return count;
    }
    
    private void initialAdj(int N, int[][] road) {
        adj = new ArrayList[N+1];
        for(int node=1; node<=N; node++) {
            adj[node] = new ArrayList<>();
        }
        
        for(int edge=0; edge<road.length; edge++) {
            int from = road[edge][0];
            int to = road[edge][1];
            int cost = road[edge][2];
            adj[from].add(new Node(to, cost));
            adj[to].add(new Node(from, cost));
        }
    }
    
    private void dijkstra(int N) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(1, 0));
        minCost = new int[N+1];
        Arrays.fill(minCost, 987_654_321);
        minCost[1] = 0;
        
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            for(Node next: adj[cur.node]) {
                if(cur.cost + next.cost < minCost[next.node]) {
                    minCost[next.node] = cur.cost + next.cost;
                    pq.add(new Node(next.node, minCost[next.node]));
                }
            }
        }
    }
}

class Node {
    int node;
    int cost;
    
    public Node(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}
