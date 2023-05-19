package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16926_230410 {
    static int[] dx = {0, 1, 0, -1}; // 우상좌하
    static int[] dy = {1, 0, -1, 0}; // 우상좌하
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        // 배열 값 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt_val = Math.min(N, M) / 2;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < cnt_val; j++) {
                int x = j;
                int y = j;

                // 나중에 값 넣어주기 위해
                int val = arr[x][y];

                // 방향
                int index = 0;

                while (index < 4) {
                    int nx = x + dx[index];
                    int ny = y + dy[index];

                    if (nx >= j && ny >= j && nx < N - j && ny < M - j) {
                        arr[x][y] = arr[nx][ny];
                        x = nx;
                        y = ny;
                    } else {
                        index++;
                    }
                }
                arr[j + 1][j] = val;
            }
        }

        for (int[] x : arr) {
            for (int y : x) {
                sb.append(y + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
