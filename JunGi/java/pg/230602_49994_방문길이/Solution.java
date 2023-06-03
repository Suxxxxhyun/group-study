/*
소요시간: 1시간
오래걸린이유: 내가 너무 못함;
1. 방문체크를 잘못함.
"처음걸어본길"은 양방향을 뜻함.
(5,5)에서 서쪽방향으로 이동했다면, (5,5,서) 방문체크와 (5,4,동) 방문체크를 함께 해줘야 함.
나는 (5,5,서)만 방문체크해서 틀렸음
*/
class Solution {
    private int[] dr = {0, -1, 1, 0}; // 동, 북, 남, 서
    private int[] dc = {1, 0, 0, -1};
    private boolean[][][] visited = new boolean[11][11][4];
    
    public int solution(String dirs) {
        int row = 5, col = 5, count = 0;
        for(char c: dirs.toCharArray()) {
            int direct = -1;
            if(c=='R') {
                direct = 0;
            } else if(c=='U') {
                direct = 1;
            } else if(c=='D') {
                direct = 2;
            } else {
                direct = 3;
            }
            int nr = row + dr[direct];
            int nc = col + dc[direct];
            if(!isInRange(nr, nc)) { continue; }
            
            if(!visited[row][col][direct] && !visited[nr][nc][3-direct]) {
                count++;
                visited[row][col][direct] = true;
                visited[nr][nc][3-direct] = true;
            }
            row = nr;
            col = nc;
        }
        return count;
    }
    
    private boolean isInRange(int r, int c) {
        return 0<=r && r<=10 && 0<=c && c<=10;
    }
}
