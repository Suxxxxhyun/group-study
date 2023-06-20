/*
2023.06.20
13:45 ~ 13:58
[Input]
- 배열A, B크기: 1 ~ 1,000 -> O(N^2)

[Type]
Goal: int[] A, B가 주어질때, "최종적"으로 "누적된" "최솟값" 구하기
유형1) 완탐: O(N^N) -> 안됨

누적값: (ai * bj) + (al * bj) + (aj * bl) + ...
-> *** 곱하기를 최소화 시켜야함 ***
[곱하기 최소화]
ex. [2, 5], [1, 3]
1) (2*1) + (5*3) -> 2, 15
2) (2*3) + (5*1) -> 6 + 5

ex. [1, 100], [99, 2]
1) (1*99) + (100*2) -> 299
2) (1*2) + (100*99) -> 9902 
-> 큰애들끼리 곱하면 x -> 비슷한애들끼리 곱하면 x -> 큰놈은 작은놈이랑 곱하는 방식?

ex. [1, 2, 4], [5, 4, 4]
(1*5) + (2*4) + (4*4) -> 5, 8, 16

ex. [1, 2], [4, 3]
(1*4) + (2*3) -> 10

ex. [3, 4], [4, 3]
1) (3*4) + (4*3) -> 24
2) (3*3) + (4*4) -> 25

[설계]
1. int[] A 오름차순, int[] B 내림차순 정렬
2. A[idx], B[idx] 끼리 곱해서 누적합
-> O(N)

[참고사항]
primitive type 배열은 내림차순 정렬의 Collections.reverseOrder()가 안됨.
-> wrapper Type[] 으로 만들고 해야함.

*/
import java.util.*;

class Solution {
    public int solution(int []A, int []B) {
        Arrays.sort(A);
        Integer[] b = new Integer[B.length];
        for(int i=0, n=B.length; i<n; i++) {
            b[i] = B[i];
        }
        Arrays.sort(b, Collections.reverseOrder());
        
        int answer = 0;
        for(int idx=0, n=A.length; idx<n; idx++) {
            answer += A[idx] * b[idx];
        }

        return answer;
    }
}
