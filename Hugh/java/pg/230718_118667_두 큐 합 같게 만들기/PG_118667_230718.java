package Programmers.Lv2;
import java.util.*;
public class PG_118667_230718 {
    /*
        10:20~
        Queue의 원소 최댓값 10억
        q1 q2 길이 같음
    */
    static long q1Sum = 0;
    static long q2Sum = 0;
    static long sum = 0;
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();


        for (int i = 0; i < queue1.length; i++) {
            q1.offer(queue1[i]);
            q1Sum += queue1[i];
        }
        for (int i = 0; i < queue2.length; i++) {
            q2.offer(queue2[i]);
            q2Sum += queue2[i];
        }

        sum = q1Sum + q2Sum;

        // 홀수인 경우 같아질 수 없음
        if (sum % 2 == 1) return -1;

        sum /= 2;
        int cnt1 = 0;
        int cnt2 = 0;
        int count = queue1.length*2;

        while (cnt1<=count && cnt2<=count) {
            // 처음부터 같을 경우 0출력
            // 그게 아닐경우 움직인 결과값 출력
            if (q1Sum == sum) return cnt1 + cnt2;

            // q1이 큰경우 q2로 옮겨줌
            if (q1Sum > sum) {
                q1Sum-=q1.peek();
                q2Sum+=q1.peek();
                q2.offer(q1.poll());
                cnt1++;
            }
            // q2이 큰경우 q1로 옮겨줌
            else {
                q2Sum-=q2.peek();
                q1Sum+=q2.peek();
                q1.offer(q2.poll());
                cnt2++;
            }

        }

        // q를 원래대로 돌릴동안 성공하지 못했다면 -1출력
        return answer;
    }
}
