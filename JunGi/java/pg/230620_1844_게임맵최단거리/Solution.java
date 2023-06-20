/*
2023.06.20
13:18 ~ 13:24
type: 0-1 bfs
*/
import java.util.*;

class Solution {
    private int R, C;
    private int[] dr = {1, -1, 0, 0};
    private int[] dc = {0, 0, 1, -1};
    private int[][] maps;
    public int solution(int[][] maps) {
        this.maps = maps;
        R = maps.length;
        C = maps[0].length;
        int answer = bfs();
        return answer;
    }
    
    private int bfs() {
        // 1. bfs start setting
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];
        q.add(new int[] {0, 0, 1});
        visited[0][0] = true;
        
        // 2. bfs start
        while(!q.isEmpty()) {
            //큐에서 꺼냄
            int[] cur = q.poll();
            int row = cur[0], col = cur[1], cost = cur[2];
            //목적지인가?
            if(row == R-1 && col == C-1) {
                return cost;
            }
            //연결된 곳
            for(int d=0; d<4; d++) {
                int nr = row + dr[d];
                int nc = col + dc[d];
                //갈수있는가?
                if(isInRange(nr, nc) && !visited[nr][nc] && maps[nr][nc] == 1) {
                    //방문체크
                    visited[nr][nc] = true;
                    //큐에넣음
                    q.add(new int[] {nr, nc, cost+1});
                }
            }
        }
        return -1;
    }
    
    private boolean isInRange(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }   
}
