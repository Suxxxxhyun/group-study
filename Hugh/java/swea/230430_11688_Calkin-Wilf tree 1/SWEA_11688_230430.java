package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_11688_230430 {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            String N = br.readLine();
            int L = 1;
            int R = 1;
            for (int j = 0; j < N.length(); j++) {
                if (N.charAt(j) == 'L') {
                    R = L + R;
                } else if (N.charAt(j) == 'R') {
                    L = L + R;
                }
            }
            sb.append(String.format("#%d %d %d\n", i, L, R));
        }
        System.out.println(sb);
    }
}
