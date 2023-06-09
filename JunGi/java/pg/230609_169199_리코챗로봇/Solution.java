import java.util.*;
/*
23.06.09 복습 (22m solve)
[BFS 설계]
1. 연결된곳: 상/하/좌/우 벽 or 격자밖 만날때까지 이동
2. 갈수있는곳: 방문x

*/
class Solution {
    private int[] dr = {1, -1, 0, 0,};
    private int[] dc = {0, 0, 1, -1};
    public int solution(String[] board) {
        int answer = bfs(board);
        return answer;
    }
    
    private int bfs(String[] board) {
        Queue<int[]> queue = new LinkedList<>();
        int[] start = getStart(board);
        queue.add(start);
        boolean[][] visited = new boolean[board.length][board[0].length()];
        visited[start[0]][start[1]] = true;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int row = cur[0], col = cur[1], cost = cur[2];
            if(isEnd(board, row, col)) { return cost; }
            
            for(int d=0; d<4; d++) {
                int nr = row, nc = col;
                
                while(isInRange(nr + dr[d], nc + dc[d], board) && 
                      !isWall(nr + dr[d], nc + dc[d], board)) {
                    nr = nr + dr[d];
                    nc = nc + dc[d];
                }
                if(!visited[nr][nc]) {
                    queue.add(new int[] {nr, nc, cost + 1});
                    visited[nr][nc] = true;
                }
            }
        }
        return -1;
    }
    
    private boolean isWall(int row, int col, String[] board) {
        return board[row].charAt(col) == 'D';
    }
    
    private boolean isInRange(int row, int col, String[] board) {
        return 0 <= row && row < board.length && 0 <= col && col < board[0].length();
    }
    
    private boolean isEnd(String[] board, int row, int col) {
        return board[row].charAt(col) == 'G';
    }
    
    private int[] getStart(String[] board) {
        for(int r=0; r<board.length; r++) {
            for(int c=0; c<board[r].length(); c++) {
                if(board[r].charAt(c) == 'R') {
                    return new int[] {r, c, 0};
                }
            }
        }
        return new int[] {};
    }
}
