/*
2023.06.14 
time: 09:11 ~ 09:31
실수1: dfs 영역 탐색 count을 파라미터로 잡았음.
-> 전역변수로 잡아야함.
-> 파라미터로 잡고 +1하면, 함수 탈출하면서 -1됨 (원상복구).

Goal: 그림의 영역개수, 가장 큰 영역의 칸 개수 구하기
Type: dfs or bfs

*/
import java.util.*;

class Solution {
    private int m, n, sizeOfArea, maxSizeOfArea, numberOfArea, count;
    private boolean[][] visited;
    private int[] dr = {1, -1, 0, 0};
    private int[] dc = {0, 0, 1, -1};
    public int[] solution(int m, int n, int[][] picture) {
        this.m = m;
        this.n = n;
        search(picture);
        int[] answer = new int[] {numberOfArea, maxSizeOfArea};
        return answer;
    }
    
    private void search(int[][] pictures) {
        visited = new boolean[m][n];
        
        for(int row=0; row<m; row++) {
            for(int col=0; col<n; col++) {
                if(!visited[row][col] && pictures[row][col] != 0) {
                    sizeOfArea = 0;
                    count = 1;
                    numberOfArea ++;
                    visited[row][col] = true;
                    dfs(row, col, pictures);
                    maxSizeOfArea = Math.max(maxSizeOfArea, sizeOfArea);
                }
            }
        }
    }
    
    private void dfs(int row, int col, int[][] pictures) {
        
        sizeOfArea = Math.max(sizeOfArea, count ++);
        
        // recur:
        for(int d=0; d<4; d++) {
            int nr = row + dr[d];
            int nc = col + dc[d];
            if(isInRange(nr, nc) && !visited[nr][nc] && pictures[row][col] == pictures[nr][nc]) {
                visited[nr][nc] = true;
                dfs(nr, nc, pictures);
            }
        }
    }
    
    private boolean isInRange(int r, int c) {
        return 0 <= r && r < m && 0 <= c && c < n;
    }
}
