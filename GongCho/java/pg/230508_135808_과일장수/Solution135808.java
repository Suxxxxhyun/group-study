package Level1;

import java.util.Arrays;
//https://devmoony.tistory.com/172 블로그 참조
//내림차순 정렬을 하지 않아도 되는 코드

public class Solution135808 {

    int answer = 0;
    public int solution(int k, int m, int[] score) {

        Arrays.sort(score);

        for(int i=score.length-1; i>=0; i--){
            if((score.length - i) % m == 0){
                answer += score[i] * m;
            }
        }
        return answer;
    }
}
