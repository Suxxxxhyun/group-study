package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_1860_230507 {
    static int T, N, M, K;
    static PriorityQueue<Integer> que;
    static int max;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            que = new PriorityQueue<>();
            max = Integer.MIN_VALUE;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                max = Math.max(max, num);
                que.add(num);
            }

            // 예외 처리
            if (que.peek() < M) {
                sb.append(String.format("#%d %s\n", i, "Impossible"));
                continue;
            }

            for (int j = 1; j <= max; j++) {
                // 붕어빵 생산
                if (j % M == 0) {
                    cnt += K;
                }

                // 같은 시간에 방문한 손님의 경우
                while (!que.isEmpty() && que.peek() == j) {
                    que.poll();
                    cnt--;
                }

                // 같은 시간에 방문한 손님이 다 사가신 경우 (바로 뒷시간 손님 구매 못함)
                if (cnt < 0) {
                    sb.append(String.format("#%d %s\n", i, "Impossible"));
                    break;
                }
            }

            if (cnt >= 0) {
                sb.append(String.format("#%d %s\n", i, "Possible"));
            }
            cnt = 0;
        }
        System.out.println(sb);
    }
}
