/*
2023.06.14
time: 13:33 ~ 13:48 (solve)
*/
class Solution {
    int solution(int[][] land) {
        int answer = dpSolve(land);
        return answer;
    }
    
    //dp 시간복잡도: 공간복잡도 * 한칸의 시간복잡도
    //O(4*N*1)
    private int dpSolve(int[][] land) {
        //1. dp배열 초기화
        int[][] dp = new int[land.length][land[0].length];
        for(int col=0; col<dp[0].length; col++) {
            dp[0][col] = land[0][col];
        }
        //2. dp
        //점화식: dp[i][j] = land[i][j] + max(dp[i-1][j열 제외한 나머지 3열])
        for(int row=1; row<dp.length; row++) {
            for(int col=0; col<4; col++) {
                if(col == 0) {
                    dp[row][col] = land[row][col] + Math.max(Math.max(dp[row-1][1], dp[row-1][2]), dp[row-1][3]);
                } else if(col == 1) {
                    dp[row][col] = land[row][col] + Math.max(Math.max(dp[row-1][0], dp[row-1][2]), dp[row-1][3]);
                } else if(col == 2) {
                    dp[row][col] = land[row][col] + Math.max(Math.max(dp[row-1][0], dp[row-1][1]), dp[row-1][3]);
                } else {
                    dp[row][col] = land[row][col] + Math.max(Math.max(dp[row-1][0], dp[row-1][1]), dp[row-1][2]);
                }
            }
        }
        int result = 0;
        for(int col=0; col<4; col++) {
            result = Math.max(dp[dp.length-1][col], result);
        }
        return result;
    }
}
