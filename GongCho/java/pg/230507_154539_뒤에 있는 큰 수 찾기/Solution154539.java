package Level2;

import java.util.*;

//https://sasca37.tistory.com/306블로그 풀이
//예시[8,9,5,6]
import java.util.*;
public class Solution154539 {

    public int[] solution(int[] numbers) {

        /* [9,5,1,1,1,1,1,1 ... ]이렇게 하여 numbers원소가 최대 백만개일때,
        9보다 큰 수는 없으므로 백만, 5보다 큰수는 없으므로 백만..
        백만 * 백만의 시간복잡도가 소요된다.
        int[] answer = new int[numbers.length];

        for(int i=0; i<numbers.length; i++){
            int num = numbers[i]; //2
            for(int j=i; j<numbers.length; j++){
                if(num < numbers[j]){
                    answer[i] = numbers[j];
                    num = numbers[j];
                    break;
                } else {
                    answer[i] = -1;
                }
            }
        }*/
        Stack<Integer> stack = new Stack<Integer>();
        int[] answer = new int[numbers.length];
        stack.push(0);

        for(int i=1; i<numbers.length; i++){
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]){
                answer[stack.pop()] = numbers[i];
            }

            stack.push(i);
        }

        while(!stack.isEmpty()){
            answer[stack.pop()] = -1;
        }
        return answer;
    }
}
