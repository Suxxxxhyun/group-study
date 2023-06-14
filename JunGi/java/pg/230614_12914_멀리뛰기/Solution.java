/*
2023.06.14
time: 11:04 ~ 11:16

Goal: 칸의 수 n이 주어질 때, 끝에 도달하는 방법의 경우의 수
type: dp (경우의 수 + 1234567를 나눈 나머지를 리턴)
완탐: O(2^n)
DP: O(n)

[DP 설계]
점화식: dp[n] n이 작은 것부터 시작해서 인접한 n과 규칙성 찾기

*/
class Solution {
    public long solution(int n) {
        long answer = dpSolve(n);
        return answer;
    }
    
    private long dpSolve(int n) {
        // 1. dp 배열 초기화
        long[] dp = new long[n+1];
        dp[1] = 1;
        if(n >= 2) { dp[2] = 2; }
        // 2. dp 점화식:
        // dp[i] = dp[i-1] + dp [i-2]
        // i칸을 가는 경우의 수 = i-1칸을 가는 경우의 수에 1칸으로 이동하는 경우 + i-2칸을 가는 경우의 수에 2칸으로 이동하는 경우
        for(int i=3; i<=n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
        }
        return dp[n] % 1234567;
    }
}
