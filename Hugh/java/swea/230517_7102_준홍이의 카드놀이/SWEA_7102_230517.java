package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7102_230517 {
    static int T, N, M;
    static int[] addArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            addArr = new int[N + M + 1];
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= M; k++) {
                    addArr[j + k] += 1;
                }
            }

            int max = Integer.MIN_VALUE;
            for (int j = 2; j < addArr.length; j++) {
                max = Math.max(max, addArr[j]);
            }

            sb.append(String.format("#%d ", i));
            for (int j = 2; j < addArr.length; j++) {
                if (addArr[j] == max) {
                    sb.append(j + " ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
