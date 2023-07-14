import java.util.*;

/** 2023.07.14 (19:03 ~ 19:20) solve

입력:
 1. works 길이: 1 ~ 20,000
 2. works 원소: 1 ~ 50,000
 3. n: 1 ~ 1,000,000
 4. 가능 시간: O(W), O(n), log scale
 
목표: 야근 피로도 최솟값 구하기

1. 야근을 하면 야근 피로도가 쌓이다.
2. 야근피로도: 야근시작시점에서의 남은 일의 작업량^2 더한값
3. Dmmi는 n시간동안 일한다.
4. Demi는 1시간 동안 작업량 1만큼 처리

---
ex1. works: [1, 1], n=3
-> edge: 남은 일들의 작업량 <= n -> 0

ex2. works: [4, 3, 3], n=4

ex3. works: [3, 3], n=2
1) 2^2 + 2^2 = 8 (V)
2) 1^2 + 3^2 = 10

ex4. works: [3, 3], n=3
1) 3^2 = 9
2) 1^2 + 2^2 = 5 (V)

ex5. works: [3, 4, 5], n=3
1) 3^2 + 3^2 + 3^2 = 27 (V)
2) 3^2 + 4^2 + 2^2 = 29

-> works를 최대한 비슷하게 맞춰야 한다.
-> pq 이용하면 시간복잡도 만족 & 구현 편할듯

설계
*edge: 남은 일들의 작업량 <= n -> 0
1. pq에 works 다 넣기
2. n만큼 pop, add -> O(n logn)
3. pop 하고, -1빼고 add
4. 종료 후, pq 다 빼면서 결괏값 계산 -> O(n logn)
*/

class Solution {
    public long solution(int n, int[] works) {
        if(isEdgeCase(n, works)) { return 0; }
        long answer = pro(n, works);
        return answer;
    }
    
    private long pro(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int work: works) {
            pq.add(work);
        }
        
        while(n --> 0) {
            int num = pq.poll() - 1;
            if(num > 0) {
                pq.add(num);
            }
        }
        
        long result = 0L;
        while(!pq.isEmpty()) {
            result += (long) Math.pow((long) pq.poll(), 2);
        }
        return result;
    }
    
    private boolean isEdgeCase(int n, int[] works) {
        int workSum = 0;
        for(int work: works) {
            workSum += work;
        }
        return workSum <= n;
    }
}
