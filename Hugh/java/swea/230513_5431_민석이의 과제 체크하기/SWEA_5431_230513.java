package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5431_230513 {
    static int T, N, K;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = new int[N + 1];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                arr[Integer.parseInt(st.nextToken())] = 1;
            }

            sb.append(String.format("#%d ", i));
            for (int j = 1; j <= N; j++) {
                if (arr[j] == 0) {
                    sb.append(j + " ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
