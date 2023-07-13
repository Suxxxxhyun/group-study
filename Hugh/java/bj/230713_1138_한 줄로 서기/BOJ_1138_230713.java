package BOJ.Implementation;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    09:02~

    구현
    1 2 3 4
    2 1 3 4
    2 3 1 4
    3 2 1 4
    4 2 1 3
    오른쪽에 큰녀석 있으면 교환?
 */
public class BOJ_1138_230713 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            q.offer(Integer.parseInt(st.nextToken()));
        }

        int[] arr = new int[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }

        // 바꿀 대상
        int cnt = 1;
        while(!q.isEmpty()) {
            // 앞에 있어야하는 사람의 수
            int order = q.poll();

            while (order-- > 0) {
                // 바꾸고 싶은 사람 찾기
                for (int i = 1; i < N; i++) {
                    if (arr[i] == cnt) {
                        for (int j = i+1; j <= N; j++) {
                            if (arr[i] < arr[j]) {
                                int tmp = arr[i];
                                arr[i] = arr[j];
                                arr[j] = tmp;
                                break;
                            }
                        }
                        break;
                    }
                }
            }
            cnt++;
        }


        for (int i = 1; i <= N; i++) {
            sb.append(arr[i]).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}
