package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5789_230514 {
    static int T, N, Q;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            Q = Integer.parseInt(st.nextToken());
            arr = new int[N];

            for (int j = 1; j <= Q; j++) {
                st = new StringTokenizer(br.readLine());
                int L = Integer.parseInt(st.nextToken()) - 1;
                int R = Integer.parseInt(st.nextToken()) - 1;

                for (int k = L; k <= R; k++) {
                    arr[k] = j;
                }
            }

            sb.append(String.format("#%d ", i));
            for (int val : arr) {
                sb.append(val + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
