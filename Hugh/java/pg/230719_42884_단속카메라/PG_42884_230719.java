package Programmers.Lv3;
import java.util.*;
public class PG_42884_230719 {
    public int solution(int[][] routes) {
        int answer = 0;

        // 도착시간 기준 정렬
        Arrays.sort(routes, (o1, o2) -> {
            return o1[1] - o2[1];
        });

        // 진입 지점과 비교해서 작다면 진출 지점으로 갱신
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < routes.length; i++) {
            // CCTV 설치하고 시작
            if (routes[i][0] > min) {
                answer++;
                min = routes[i][1];
            }

        }

        return answer;
    }
}
