package BOJ.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1966_230321 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            LinkedList<int[]> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                // {초기위치, 중요도}
                q.offer(new int[] {i, Integer.parseInt(st.nextToken())});
            }
            int cnt = 0; // 출력 횟수

            while(!q.isEmpty()) { // 한 케이스에 대한 반복문

                int[] front = q.poll(); // 가장 첫 원소
                boolean isMax = true; // front 원소가 가장 큰 원소인지를 판단하는 변수

                // 큐에 남아있는 원소들과 중요도 비교
                for(int i = 0; i < q.size(); i++) {

                    // 처음 뽑은 원소보다 큐에 있는 i번째 원소가 더 클 경우
                    if(front[1] < q.get(i)[1]) {

                        // 뽑은 원소 및 i 이전의 원소들 뒤로 보냄.
                        q.offer(front);
                        for(int j = 0; j < i; j++) {
                            q.offer(q.poll());
                        }


                        // front원소가 가장 큰 원소가 아니였으므로 false를 하고 탐색을 마침
                        isMax = false;
                        break;
                    }
                }

                // front 원소가 가장 큰 원소가 아니였으므로 다음 반복문으로 넘어감
                if(isMax == false) {
                    continue;
                }

                // front 원소가 가장 큰 원소였으므로 해당 원소 출력
                cnt++;
                if(front[0] == m) {
                    break;
                }
            }
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}
