import java.util.*;

/** 2023.07.14 (18:35 ~ 18:57) ref: https://zzang9ha.tistory.com/195

learned:
 1. 서로 다른 수의 곱이 최대가 되려면, 서로 다른 수가 최대한 비슷해야 한다.
 2. n개의 서로 다른 수가 s가 되는데, 최대곱이 되려면
    [s/n, s/n, s/n, ...] -> s%n개 만큼 1씩 증가 -> [s/n + 1, s/n + 1, .. s/n + 1, s/n, s/n, ..]

입력:
 1. 자연수 개수 n: 1 ~ 10,000
 2. 모든원소의 합 s: 1 ~ 100,000,000
 2. 가능 시간복잡도: O(n^2), O(n logn), O(s), O(n logs)

목표: 최고의 집합 구하기

최고의 집합
1. 각 원소의 합이 s
2. 동시에, 각 원소의 곱이 최대

ex1. n=2, s=9
1. 합이 9인 집합들: {1, 8}, {2, 7}, {3, 6}, {4, 5}
2. 곱이 최대인 집합: {4, 5}

모르겠으면 예제 봐라 좀

ex1. n=2, s=1
res = [-1]
-> n > s이면 -1이다.
-> 수는 모두 자연수이기 때문
-> 모든 수가 1이어도 s를 만족할 수 없음

ex2. n=2, s=9
res = [4, 5]

ex3. n=2, s=8
res = [4, 4]

-> 곱이 최대가 되려면 n개의 수가 서로 최대한 비슷해야 한다.

ex4. n=2, s=10
res = [5, 5]

ex5. n=2, s=11
res = [5, 6]

ex6. n=3, s=12
res = [4, 4, 4]

ex7. n=3, s=13
res = [4, 4, 5]

ex8. n=3, s=14
res = [4, 5, 5]

-> 곱이 최대가 되려면 n개의 수가 서로 최대한 비슷해야 하므로,
-> res = [s/n, s/n, ..] 으로 초기화
-> s%n 개수만큼 res[i]를 1씩 증가

[설계]
* edge case: n > s -> return [-1]
1. res[] 초기화: res[i] = s/n
2. res[] 값만들기: s%n 개수만큼 res[i]를 1씩 증가
3. res 오름차순 정렬

*/

class Solution {
    public int[] solution(int n, int s) {
        if(isEdgeCase(n, s)) {
            return new int[] {-1};
        }
        int[] answer = pro(n, s);
        return answer;
    }
    
    private int[] pro(int n, int s) {
        int[] res = getRes(n, s);
        Arrays.sort(res);
        return res;
    }
    
    private int[] getRes(int n, int s) {
        int[] res = new int[n];
        // 1. res[] 초기화: res[i] = s/n
        for(int i=0; i<n; i++) {
            res[i] = s / n;
        }
        // 2. res[] 값만들기: s%n 개수만큼 res[i]를 1씩 증가
        for(int i=0; i<s%n; i++) {
            res[i] += 1;
        }
        return res;
    }
    
    private boolean isEdgeCase(int n, int s) {
        return n > s;
    }
}
