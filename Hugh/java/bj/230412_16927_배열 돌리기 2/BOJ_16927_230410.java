package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16927_230410 {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int[][] arr;
    static int N,M,R;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        // 배열 값 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int n = N, m = M;

        for (int i = 0; i < Math.min(N, M) / 2; i++) {
            rotate(i, (n*2) + (m*2) - 4);
            n -= 2;
            m -= 2;
        }

        for(int x[] : arr) {
            for (long y : x) {
                sb.append(y + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void rotate (int start, int len) {

        int rL = R % len;

        for (int j = 0; j < rL; j++) {
            int x = start;
            int y = start;
            // 끝나고 붙이기 위해
            int pre = arr[start][start];
            int idx = 0;


            while (idx < 4) {
                int nx = x + dx[idx];
                int ny = y + dy[idx];

                if (nx >= start && ny >= start && nx < N - start && ny < M - start) {
                    arr[x][y] = arr[nx][ny];
                     x = nx;
                     y = ny;
                } else {
                    idx++;
                }
            }
            arr[start + 1][start] = pre;
        }
    }
}
