import java.util.*;

/** 2023.07.03 (10:07 ~ 10:45)
 * Time Complexity: O(N^2)
 * Goal: 문제 방식으로 arr 압축 -> 배열에 최종적으로 남는 0의 개수와 1의 개수 구하기
 * Type: 재귀
 
[재귀설계]
dfs(시작행, 시작열, 탐색길이) -> dfs(startRow, startCol, length)
1. base case1: 탐색길이가 0인 경우
 -> return
2. base case2: 현재 영역의 수가 모두 같은 경우
 -> 숫자 갱신, 압축 표시
 -> return
3. recur case: 1 ~ 4사분면
*/

class Solution {
    private int zeroCount, oneCount;
    private int[][] board;
    private boolean[][] visited;
    public int[] solution(int[][] arr) {
        this.board = arr;
        visited = new boolean[arr.length][arr.length];
        dfs(0, 0, arr.length);
        updateNonZipCount();
        return new int[] {zeroCount, oneCount};
    }
    
    private void updateNonZipCount() {
        for(int row=0, n=board.length; row<n; row++) {
            for(int col=0; col<n; col++) {
                if(!visited[row][col] && board[row][col] == 1) {
                    oneCount ++;
                }
                if(!visited[row][col] && board[row][col] == 0) {
                    zeroCount ++;
                }
            }
        }
    }
    
    private void dfs(int startRow, int startCol, int length) {
        
        // check: 다른 수가 있는지 확인
        boolean allNumSame = isAllNumSame(startRow, startCol, length);
        
        // base1: 길이가 0인 경우
        if(length == 0) {
            return;
        }
        
        // base2: 모두 같은 수인 경우 -> 마킹, 숫자개수 갱신
        if(allNumSame && length!=1) {
            marking(startRow, startCol, length);
            updateCount(startRow, startCol);
            return;
        }
    
        // recur:
        // 갈수: 다른수가 있는 경우
        // 연결: 1~4사로
        dfs(startRow, startCol + length/2, length/2);
        dfs(startRow, startCol, length/2);
        dfs(startRow + length/2, startCol, length/2);
        dfs(startRow + length/2, startCol + length/2, length/2);
        
    }
    
    private void updateCount(int row, int col) {
        if(board[row][col] == 0) {
            zeroCount ++;
        } else {
            oneCount ++;
        }
    }
    
    private void marking(int startRow, int startCol, int length) {
        for(int row=startRow; row<startRow+length; row++) {
            for(int col=startCol; col<startCol+length; col++) {
                visited[row][col] = true;
            }
        }
    }
    
    private boolean isAllNumSame(int startRow, int startCol, int length) {
        boolean allNumSame = true;
        int num = board[startRow][startCol];
        for(int row=startRow; row<startRow+length; row++) {
            for(int col=startCol; col<startCol+length; col++) {
                if(num != board[row][col]) {
                    allNumSame = false;
                    break;
                }
            }
        }
        return allNumSame;
    }
}
