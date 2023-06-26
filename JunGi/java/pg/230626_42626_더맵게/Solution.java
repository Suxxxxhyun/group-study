/*
2023.06.26
09:13 ~ 09:33
Goal: 모든 음식의 스코빌 지수를 K이상으로 만들기 위해 섞어야하는 최소횟수는?
Type: 
 - 우선순위큐(O) -> N번 삽입.삭제하면 O(N * logN) -> 가능
 - 정렬(X) -> 정렬을 N번하면 O(N * NlogN) -> O(N^2) -> TLE

[설계]
1. 가장 낮은 스코빌이 K이상이면 종료한다.
2. 가장 낮은 두개의 스코빌로 섞은스코빌을 계산한다.
3. 음식을 추가한다.
스코빌이 1개이고 값이 K미만이면 return -1
*/
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = pro(arrayToPQ(scoville), K);
        return answer;
    }
    
    private int pro(PriorityQueue<Long> pq, int K) {
        int count = 0;
        while(pq.size() > 1) {
            long one = pq.poll();
            // 가장 낮은 스코빌이 K이상이면 종료한다.
            if(one >= K) {
                break;
            }
            long two = pq.poll();
            // 1. 가장 낮은 두개의 스코빌로 섞은스코빌을 계산한다.
            long shake = one + two * 2L;
            // 2. 음식을 추가한다.
            pq.add(shake);
            count++;
        }
        // 스코빌이 1개이고 값이 K미만이면 return -1
        if(pq.size() == 1 && pq.peek() < K) {
            return -1;
        }
        return count;
    }
    
    private PriorityQueue<Long> arrayToPQ(int[] scoville) {
        PriorityQueue<Long> pq = new PriorityQueue();
        for(int s: scoville) {
            pq.add((long)s);
        }
        return pq;
    }
}
