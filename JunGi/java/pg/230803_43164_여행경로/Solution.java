/** 2023.07.25 (10:03 ~ 10:40) 1차

2023.08.03 (09:05 ~ 09:35)

입력:
 1. 공항 수 V: 3 ~ 10,000
 2. tickets [a, b]: a -> b (단방향)
 3. 가능 시간복잡도: O(V), log scale
 
목표: 간선 정보가 주어질 때, 방문하는 공항경로 구하기

- 주어진 간선을 모두 지나가야 한다.
- 가능 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로여야 한다.
- 반드시 모든 도시를 방문하는 케이스만 주어진다.
- 항상 "ICN"공항에서 출발한다.

설계
*. 그래프 표현: Map<String, List<Edge>>
    ICN [Edge1(ATL, false), Edge2(SFO, false)]
    SFO [Edge1(ATL, false)] ...
1. base case1: depth == 총edge 개수 (모든 간선을 방문)
2. base case2: 인접한 간선이 없는 경우 (null 임)
3. 연결: 현재 방문 노드에서 연결된 간선 (인접한 간선)
4. 갈수: 지나가지 않은 간선
5. 방문체크: 간선 visited true
6. 방문해제: 간선 visited false

*/
import java.util.*;

class Solution {
    private int E;
    private boolean flag;
    private String[] result;
    private Map<String, List<Edge>> adj;
    public String[] solution(String[][] tickets) {
        E = tickets.length;
        initAdj(tickets);
        
        List<String> path = new ArrayList<>();
        path.add("ICN");
        
        dfs("ICN", 0, path);
        return result;
    }
    
    private void updateResult(List<String> path) {
        result = new String[path.size()];
        for(int idx=0; idx<path.size(); idx++) {
            result[idx] = path.get(idx);
        }
    }
    
    private void initAdj(String[][] tickets) {
        adj = new HashMap<>();
        for(int edge=0; edge<E; edge++) {
            String from = tickets[edge][0];
            String to = tickets[edge][1];
            
            if(!adj.containsKey(from)) {
                adj.put(from, new ArrayList<>());
            }
            adj.get(from).add(new Edge(to, false));
        }
        // 알파벳 순서가 앞서는 경로를 return 해야 하므로, 정렬
        for(List<Edge> edges: adj.values()) {
            Collections.sort(edges, (o1, o2) -> o1.node.compareTo(o2.node));
        }
    }
    
    private void dfs(String cur, int visitEdgeCount, List<String> path) {
        
        //base:
        if(visitEdgeCount == E) {
            flag = true;
            updateResult(path);
            return;
        }
        //base2: 인접한 간선이 없을 경우, Map이므로 null point 주의
        if(!adj.containsKey(cur)) {
            return;
        }
        
        //recur:
        //연결된곳: 인접한 간선
        for(Edge next: adj.get(cur)) {
        //갈수?: 지나가지 않은 간선, base 아직 도달 x
            if(!next.visited && !flag) {
                //방문체크: 간선 visited true, 경로 추가
                path.add(next.node);
                next.visited = true;
                //간다
                dfs(next.node, visitEdgeCount + 1, path);
                //방문해제: 간선 visited false
                path.remove(path.size()-1);
                next.visited = false;
            }
        }
    }
}

class Edge {
    String node;
    boolean visited;
    
    public Edge(String node, boolean visited) {
        this.node = node;
        this.visited = visited;
    }
}
