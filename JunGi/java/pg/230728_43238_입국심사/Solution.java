/** 2023.07.28 (11:58 ~ 12:28) solve

입력:
 1. 사람 N명: 1 ~ 10억
 2. 심사관 M명: 1 ~ 10만
 3. 한 명을 심사하는데 걸리는 시간: 1분 ~ 10억분
 4. 가능 시간복잡도: O(logN), O(M logN)
 
목표: 모든 사람이 심사를 받는데 걸리는 최소 시간

*핵심!!!*
O(M logN)
-> 사람을 logN으로 탐색할 필요가 있나?
-> 어차피 사람은 순서대로 심사를 받음. -> O(1)
-> log scale로 풀어야하는데, **어떤 값(변수)를 log scale로 접근해야 하지?**
-> 전체시간 T에 대해서 log scale로 줄여나가는 방법은?
-> ex. T=20분일 때, 모든 사람 심사 가능 -> T=10분일 때 확인 , ...

[파라미터릭 서치 설계]
가능한 형태임 [T, T, T, T, ..., F, F, F, F]
-> 10분일 때, 모든 사람이 탐색 가능하다면 10분 넘는 시간도 당연히 모든 사람 탐색 가능
-> [탐색 후보군, 정답후보, T, T, T, T, T]

-> 10분일 때, 모든 사람이 탐색 불가하다면 10분 미만 시간도 당연히 모든 사람 탐색 불가
-> [F, F, F, F, F, 탐색 후보군]

O(M * logT)
-> 한번의 이분 탐색 당, O(M) 으로 끝내야 함.
-> O(M)으로 모든 사람 탐색 가능 여부 확인하는 방법은?
        
        7   10
n=1     0   0
n=2     7   10
n=3     14  20
n=4     21  30
n=5     28  40
n=6     35  50

-> times 오름차순 정렬
-> time = T일 때, checkedTotalPerson += (T / times[i])

*/
import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long answer = parametricSearch(n, times);
        return answer;
    }
    
    private long parametricSearch(int n, int[] times) {
        long left = 1L;
        long right = 1_000_000_000_000_000_000L;    // worst: 사람10억명, 심사관1명, 10억분 -> 10억^2
        long result = 0L;
        while(left <= right) {
            long mid = (left + right) / 2;
            //[탐색 후보군, (mid)정답후보, T, T, T, T, T]
            if(canAllPeopleChecked(mid, n, times)) {
                result = mid;
                right = mid - 1;
            } else {//[F, F, F, F, (mid)F, 탐색 후보군]
                left = mid + 1;
            }
        }
        return result;
    }
    
    private boolean canAllPeopleChecked(long totalTime, int n, int[] times) {
        long checkedTotalPerson = 0L;
        for(int time: times) {
            checkedTotalPerson += totalTime / time;
        }
        // System.out.println("checkedTotalPerson: " + checkedTotalPerson);
        return checkedTotalPerson >= n;
    }
}
