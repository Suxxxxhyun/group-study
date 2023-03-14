package Programmers;

class Solution64062 {
    public long solution(int[] stones, int k) {
        long answer = 0;
        long L = 1, R = 200000000;
        while(L <= R){
            long mid = (L + R) / 2;
            if(determination(mid, k, stones)){
                L = mid + 1;
                answer = mid;
            } else {
                R = mid - 1;
            }
        }
        return answer;
    }
    
    public boolean determination(long x, int k, int[] stones){
        int cnt = 0;
        for(int i=0; i<stones.length; i++){
            if(x > stones[i]){
                cnt++;
            } else {
                cnt = 0;
            }
            if(cnt == k){
                return false;
            }
        }
        return true;
    }
}
