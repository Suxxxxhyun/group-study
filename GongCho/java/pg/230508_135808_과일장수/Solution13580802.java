package Level1;

import java.util.*;

//내림차순을 적용한 코드
public class Solution13580802 {

    int answer = 0;
    public int solution(int k, int m, int[] score) {

        Integer[] s = Arrays.stream(score).boxed().toArray(Integer[] :: new);
        Arrays.sort(s, Collections.reverseOrder());

        for(int i=0; i<s.length; i++){
            if((i + 1) % m == 0){
                answer += score[i] * m;
            }
        }

        return answer;
    }
}
