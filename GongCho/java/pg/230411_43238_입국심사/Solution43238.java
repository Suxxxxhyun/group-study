package Level3;

import java.util.*;
//최댓값이나 최솟값이 나오면 무조건 파라메터릭 서치를 의심하자.
//파라메터릭서치 유형은 문제자체를 아예바꿔서 풀어야하는데,
//물어보고자하는 것을 매개변수로 설정한뒤, 그 매개변수가 될 수 있는지 없는지를 판단하자.
//임이의 시간을 설정한뒤, 그 시간에 모든 사람을 심사할 수 있냐? 없냐?
public class Solution43238 {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);

        long L = 1, R = (long)times[times.length-1] * (long)n;
        while(L <= R){
            long mid = (L + R) / 2;

            if(determination(mid, times, n)){
                R = mid - 1;
                answer = mid;
            } else {
                L = mid + 1;
            }
        }
        return answer;
    }

    static boolean determination(long x, int[] times, int n){
        long sum = 0;
        for(int time : times){
            sum += x / time;
        }
        return (sum >= n) ? true : false;
    }
}
