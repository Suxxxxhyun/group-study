package Programmers;

import java.util.*;
public class PG_118667_230628 {
    class Solution {
        public int solution(int[] queue1, int[] queue2) {

            Queue<Integer> q1 = new LinkedList<>();
            Queue<Integer> q2 = new LinkedList<>();
            int len = queue1.length;
            long sum1 = 0;
            long sum2 = 0;

            long target = (sum1 + sum2) / 2;

            int answerCnt = 0;



            for(int i=0;i<len;i++){
                sum1 += queue1[i];
                sum2 += queue2[i];
                q1.offer(queue1[i]);
                q2.offer(queue2[i]);
            }

            while(sum1 != sum2){
                if(answerCnt >= len*3) return -1;

                if(sum1 > sum2){

                    sum1 -= q1.peek();
                    q2.offer(q1.peek());
                    sum2 += q1.poll();

                }else{
                    sum2 -= q2.peek();
                    q1.offer(q2.peek());
                    sum1 += q2.poll();
                }
                answerCnt++;

            }

            return answerCnt;
        }
    }
}
