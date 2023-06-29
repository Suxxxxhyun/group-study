// 10:40 ~ 
/*
- O, X를 번갈아가며 진행한다.

1. O, X개수 차이:
 1) O개수 == X개수
 2) O개수 == X개수-1
 
2. 둘 다 이기면 안됨
 
3. O가 이겼다면, O개수 == X개수-1
4. X가 이겼다면, O개수 == X개수
 
*/
class Solution {
    private char[][] board = new char[3][3];
    public int solution(String[] board) {
        
        for(int row=0; row<3; row++) {
            for(int col=0; col<3; col++) {
                this.board[row][col] = board[row].charAt(col);
            }
        }
        
        
        int oCount = getTargetCount('O');
        int xCount = getTargetCount('X');
        // System.out.printf("oCount: %d, xCount: %d\n", oCount, xCount);
        
        //1. O개수 == X개수 or O개수+1 == X개수
        if(oCount != xCount && oCount-1 != xCount) { // 조건 잘못 설정해서 틀림 (테케20번)
            return 0;
        }
        
        boolean oWin = isTargetWin('O');
        boolean xWin = isTargetWin('X');
        //2. 둘다 이기면 안된다.
        if(oWin && xWin) {
            return 0;
        }
        
        //3. O가 이긴경우, O개수 == X개수-1
        if(oWin && oCount == xCount) {
            return 0;
        }
        //4. x가 이긴경우, O개수 == X개수
        if(xWin && oCount != xCount) {
            return 0;
        }
        return 1;
    }
    
    private boolean isTargetWin(char target) {
        int rowWin = isRowWin(target);
        int colWin = isColWin(target);
        int diagonalWin = isDiagonalWin(target);
        // System.out.printf("rowWin:%d, colWin:%d, diagonalWin:%d\n", rowWin, colWin, diagonalWin);
        if(rowWin==1 && colWin==0 && diagonalWin==0) {
            return true;
        }
        if(rowWin==0 && colWin==1 && diagonalWin==0) {
            return true;
        }
        if(rowWin==0 && colWin==0 && diagonalWin==1) {
            return true;
        }
        return false;
    }
    
    private int isRowWin(char target) {
        int rowWin = 0;
        for(int row=0; row<3; row++) {
            if((board[row][0] == board[row][1]) && (board[row][1] == board[row][2]) && (board[row][2] == target)) {
                rowWin ++;
            }
        }
        // System.out.println(target + " row win is " + rowWin);
        return rowWin;
    }
    
    private int isColWin(char target) {
        int colWin = 0;
        for(int col=0; col<3; col++) {
            if((board[0][col] == board[1][col]) && (board[1][col] == board[2][col]) && (board[2][col] == target)) {
                colWin ++; 
            }
        }
        // System.out.println(target + " col win is " + colWin);
        return colWin;
    }
    
    private int isDiagonalWin(char target) {
        int diagonalWin = 0;
        // '/' 승리여부
        if((board[0][2] == board[1][1]) && (board[1][1] == board[2][0]) && (board[2][0] == target)) {
            diagonalWin ++;
        }
        // '\' 승리여부
        if((board[0][0] == board[1][1]) && (board[1][1] == board[2][2]) && (board[2][2] == target)) {
            diagonalWin ++;
        }
        // System.out.println("diagonal win is false");
        return diagonalWin;
    }
    
    private int getTargetCount(char target) {
        int targetCount = 0;
        for(int row=0; row<3; row++) {
            for(int col=0; col<3; col++) {
                if(board[row][col] == target) {
                    targetCount++;
                }
            }
        }
        return targetCount;
    }
}
