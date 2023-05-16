package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_10505_230430 {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];
            int sum = 0;
            int max = Integer.MAX_VALUE;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                sum += arr[j];
                if (max < arr[j]) {
                    max = arr[j];
                }
            }
            int average = sum / N;
            int result = 0;
            for (int j = 0; j < N; j++) {
                if (arr[j] <= average) {
                    result++;
                }
            }
            sb.append(String.format("#%d %d\n", i, result));
        }
        System.out.println(sb);
    }
}
