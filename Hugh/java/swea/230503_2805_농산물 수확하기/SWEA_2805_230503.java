package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_2805_230503 {
    static int T;
    static int start, end;
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            for (int j = 0; j < N; j++) {
                String str = br.readLine();
                for (int k = 0; k < N; k++) {
                    arr[j][k] = Integer.parseInt(String.valueOf(str.charAt(k)));
                }
            }
            // 선언
            start = N / 2;
            end = N / 2;

            upStream(N, arr);
            downStream(N, arr);
            sb.append(String.format("#%d %d\n", i, sum));

            // 초기화
            sum = 0; start = 0; end = 0;
        }
        System.out.println(sb);
    }

    // y축 1 ~ N/2 까지
    static void upStream(int N, int[][] arr) {
        for (int j = 0; j < N; j++) {
            for (int k = start; k <= end; k++) {
                sum += arr[j][k];
            }
            if (end == N - 1) {
                start++;
                end--;
                break;
            }
            start--;
            end++;
        }
    }

    // y축 (N/2)+1 ~ N-1 까지
    static void downStream(int N, int[][] arr) {
        for (int j = (N / 2) + 1; j < N; j++) {
            for (int k = start; k <= end; k++) {
                sum += arr[j][k];
            }
            start++;
            end--;
        }
    }
}
