package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3431_230430 {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int U = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());

            if (L > X) {
                sb.append(String.format("#%d %d\n", i, L - X));
            } else if (L <= X && X <= U) {
                sb.append(String.format("#%d %d\n", i, 0));
            } else if (U < X) {
                sb.append(String.format("#%d %d\n", i, -1));
            }
        }

        System.out.println(sb);
    }
}
