package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3499_230509 {
    static int T, N;
    static String[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            N = Integer.parseInt(br.readLine());
            arr = new String[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j += 2) {
                arr[j] = st.nextToken();
            }
            for (int j = 1; j < N; j += 2) {
                arr[j] = st.nextToken();
            }

            sb.append(String.format("#%d ", i));
            for (int j = 0; j < N; j ++) {
                sb.append(arr[j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
