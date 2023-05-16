package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_9229_230506 {
    static int TC, N, M;
    static int[] arr;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        TC = Integer.parseInt(br.readLine());

        for (int i = 1; i <= TC; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            max = Integer.MIN_VALUE;
            for (int j = 0; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (arr[j] + arr[k] <= M) {
                        max = Math.max(max, arr[j] + arr[k]);
                    }
                }
            }

            if (max == Integer.MIN_VALUE) {
                sb.append(String.format("#%d %d\n", i, -1));
            } else {
                sb.append(String.format("#%d %d\n", i, max));
            }
        }
        System.out.println(sb);
    }
}
