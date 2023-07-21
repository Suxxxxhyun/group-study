package Programmers.Lv3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


/*
    입력할때는 배열의 sort를 사용해서 시작이 빠른것부터 넣어주고, 꺼낼때는 종료가 빠른 것부터 꺼낼 수가 있다?

    *배열요소*
    [작업시작시간, 소요시간]
*/

public class PG_42627_230721 {
    public static void main(String[] args) {
        int[][] jobs = new int[][]{{0,3},{1,9},{2,6}};
        System.out.println(solution(jobs));
    }
    static int solution(int[][] jobs) {
        int answer = 0; // 정답 입력

        // 종료시간 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        // 시작시간 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        int index = 0;
        int end = 0; // 마지막 부분
        int count = 0;
        while (count < jobs.length) {

            // end의 범위 안에 있다면
            while(index < jobs.length && jobs[index][0] <= end) {
                pq.offer(jobs[index++]);
            }

            if (pq.isEmpty()) {
                end = jobs[index][0];
            } else {
                int[] cur = pq.poll();
                answer += (cur[1] + end - cur[0]);
                end += cur[1];
                count++; // 필요할 때는 올리고 필요없을 때는 내리고
            }
        }

        return answer / jobs.length;
    }
}
