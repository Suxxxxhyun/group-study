import java.util.*;

/** 2023.07.14 (09:45 ~ 09:57)

입력:
 1. 노드개수n: 1 ~ 200
목표: 네트워크의 개수
 -> 집합의 개수
 -> 유니온 파인드

*/

class Solution {
    private int[] parent;
    public int solution(int n, int[][] computers) {
        initParent(n);
        
        int answer = pro(n, computers);
        return answer;
    }
    
    private int pro(int n, int[][] computers) {
        for(int from=0; from<n; from++) {
            for(int to=0; to<n; to++) {
                if(from == to) continue;
                if(computers[from][to] == 0) continue;
                union(from, to);
            }
        }
        return getParentCount(n);
    }
    
    private int getParentCount(int n) {
        for(int i=0; i<n; i++) {    // 경로압축이 안된 노드들이 있을 수 있으므로, 한 번 돌려줘야 함
            find(i);
        }
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++) {
            set.add(parent[i]);
        }
        return set.size();
    }
    
    private void initParent(int n) {
        parent = new int[n];
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }
    }
    
    private void union(int nodeA, int nodeB) {
        int rootA = find(nodeA);
        int rootB = find(nodeB);
        
        if(rootA != rootB) {
            parent[rootA] = rootB;
        }
    }
    
    private int find(int node) {
        if(parent[node] == node) {
            return node;
        }
        return parent[node] = find(parent[node]);
    }
}
