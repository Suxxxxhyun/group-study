/** 2023.07.25 (12:37 ~ )

15:41 ~ 

입력:
 1. 징검다리를 건너야 하는 사람 개수: 무제한
 2. stones개수: 1 ~ 20만
 3. 한 번에 건너뛸 수 있는 디딤돌의 최대 칸수 k: 1 ~ stones개수
 
 
목표: 최대 몇 명까지 징검다리를 건널 수 있는지 구하기

- 디딤돌의 숫자는 한 번 밟을 때마다 1씩 줄어든다.
- 디딤돌의 숫자가 0이 되면 더 이상 밟을 수 없고, 이때는 그 다음 디딤돌로 한번에 여러 칸을 건너 뛸 수 있다.
- 단, 다음으로 밟을 수 있는 디딤돌이 여러개인 경우 무조건 가장 가까운 디딤돌로만 건너 뛸 수 있다.

stones:   [2, 4, 5, 3, 2, 1, 4, 2, 5, 1]
1명지나감: [1, 3, 4, 2, 1, 0, 3, 1, 4, 0]
2명지나감: [0, 2, 3, 1, 0, 0, 2, 0, 3, 0]
3명지나감: [0, 1, 2, 0, 0, 0, 1, 0, 2, 0]

4명지나감: [0, 0, 1, 0, 0, 0, 0, 0, 1, 0]

문제의 조건에 의해, 0이 아닌 디딤돌은 "차례대로" 밟는 구조임.
즉, 만약 3명이 지나갔다고 가정하면 stones[i]를 3씩 빼줘도 무방함.



*/

class Solution {
    public int solution(int[] stones, int k) {
        int answer = parametricSearch(stones, k);
        return answer;
    }
    
    private int parametricSearch(int[] stones, int k) {
        long left = 1L;
        long right = 200_000_000L;
        long result = 0L;
        
        while(left <= right) {
            long mid = (left + right) / 2;
            boolean canGo = calculateCanGo(mid, stones, k);
            if(canGo) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int) result;
    }
    
    private boolean calculateCanGo(long personCount, int[] stones, int k) {
        // personCount - 1명이 지나갔을 때, 연속된 디딤돌 0의 개수가 k개 미만이면, personCount도 지나갈 수 있다.
        int continousZeroCount = 0;
        for(int idx=0; idx<stones.length; idx++) {
            if(stones[idx] - personCount + 1 <= 0) {
                continousZeroCount ++;
                if(continousZeroCount >= k) {
                    return false;
                }
            } else {
                continousZeroCount = 0;
            }
        }
        return true;
    }
}
