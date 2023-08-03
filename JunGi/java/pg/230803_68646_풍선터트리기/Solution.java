/** 2023.08.03 (09:39 ~ 10:22)
설계만 30~40분 쓴듯. 구현은 어렵지 않았음.

입력:
 1. a의 길이: 1 ~ 1,000,000
 2. a[i]: i+1번째 풍선에 써진 숫자
 3. a[i]: -10억 ~ 10억 -> long type 고려
 4. a[i]: 모두 다름
 5. 가능 시간복잡도: O(A), log scale
 
목표: 규칙대로 풍선들을 1개만 남을 때까지 터트렸을 때, 최후까지 남기는 것이 가능한 풍선들의 개수 구하기

규칙1: 인접 두 풍선 중 하나 터트림
규칙2: 터트린 후, 빈 공간 없이 풍선들 밀착시킴
조건1: 번호가 더 작은 풍선을 터뜨리는 행위는 최대 1번만 할 수 있음
-> 그 이후에는 번호가 더 큰 풍선만을 터트릴 수 있음

풍선 i의 양 옆(왼쪽, 오른쪽 구분!) 풍선들이
1) 풍선 i보다 모두 크거나,
2) 풍선 i보다 작은게 하나만 있는 경우

-> 풍선 i기준, 양 옆의 최솟값을 O(N)보다 빠르게 구하는 방법은?
-> 왼쪽영역 최솟값, 오른쪽영역 최솟값 미리 구해놓자

설계
a[]:       -16  27  65  -2  58 -92 -71 -68 -61 -33

->방향최솟값: -16 -16 -16 -16 -16 -92 -92 -92 -92 -92
<-방향최솟값: -92 -92 -92 -92 -92 -92 -71 -68 -61 -33

a[target] = ->방향최솟값[target-1] , <-방향최솟값[target+1]만 확인하면 됨
a[first], a[last]는 무조건 가능

*/

import java.util.*;

class Solution {
    public int solution(int[] a) {
        int answer = 0;
        answer = pro(a);
        return answer;
    }
    
    private int pro(int[] a) {
        //edge
        if(a.length == 1) {
            return 1;
        }
        if(a.length == 2) {
            return 2;
        }
        int answer = 2; //맨 처음, 끝 풍선은 무조건 살릴 수 있다.
        int[] leftMin = getLeftMin(a);
        int[] rightMin = getRightMin(a);
        
        for(int idx=1; idx<a.length-1; idx++) {
            int target = a[idx];
            if(leftMin[idx-1] < target && rightMin[idx+1] < target) {
                continue;
            }
            answer ++;
        }
        return answer;
    }
    
    private int[] getRightMin(int[] a) {
        int[] arr = new int[a.length];
        int min = Integer.MAX_VALUE;
        for(int idx=a.length-1; idx>=0; idx--) {
            min = Math.min(min, a[idx]);
            arr[idx] = min;
        }
        return arr;
    }
    
    private int[] getLeftMin(int[] a) {
        int[] arr = new int[a.length];
        int min = Integer.MAX_VALUE;
        for(int idx=0; idx<a.length; idx++) {
            min = Math.min(min, a[idx]);
            arr[idx] = min;
        }
        return arr;
    }
    
    private void print(int[] a) {
        System.out.println(Arrays.toString(a));
    }
}
