/*
14:20~ 14:58
Goal: 경우의 수
Type: 백트래킹
*/

import java.util.*;

class Solution {
    private int answer = 0;
    public int solution(int n) {
        int[] chessRecord = new int[n];
        Arrays.fill(chessRecord, -1);
        dfs(-1, 0, n, chessRecord);
        return answer;
    }
    
    private void dfs(int row, int col, int n, int[] chessRecord) {
        
        // base:
        if(row == n-1) {
            answer ++;
            return;
        }
        // recur:
        for(int nc=0; nc<n; nc++) {
            if(isExistSameDiagonal(chessRecord, row+1, nc) || isExistSameCol(chessRecord, row+1, nc)) {
                continue;
            }
            chessRecord[row+1] = nc;
            dfs(row+1, nc, n, chessRecord);
            chessRecord[row+1] = -1;
        }
    }
    
    //대각선: (row,col)  , (nr, nc)    가로길이 == 세로길이
    //chessRecord의 idx: row
    //chessRecord[i] elem: col
    private boolean isExistSameDiagonal(int[] chessRecord, int nr, int nc) {
        for(int row=nr-1; row>=0; row--) {
            int col = chessRecord[row];
            if(Math.abs(row - nr) == Math.abs(col - nc)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean isExistSameCol(int[] chessRecord, int nr, int nc) {
        for(int row=nr-1; row>=0; row--) {
            int col = chessRecord[row];
            if(col == nc) {
                return true;
            }
        }
        return false;
    }
}
