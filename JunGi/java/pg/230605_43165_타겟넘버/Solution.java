/*
[설계]
Goal: 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수 구하기
유형1. [+, -] 경우의 수 완전탐색 -> O(2^20)
유형2. 
*/
class Solution {
    private static int count = 0;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        dfs(numbers, 0, 0, target);
        return count;
    }
    
    private void dfs(int[] numbers, int result, int idx, int target) {
        
        if(idx == numbers.length) {
            if(result == target) { count++; }
            return;
        }

        dfs(numbers, result + numbers[idx], idx+1, target);
        dfs(numbers, result + numbers[idx] * -1, idx+1, target);
    }
}
