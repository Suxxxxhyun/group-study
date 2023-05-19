package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_16910_230430 {
    static int T;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            int def = 5;
            if (N == 1) {
                sb.append(String.format("#%d %d\n", i, def));
                continue;
            }
            int total = 0;
            for (int y = N; y >= -N; y--) {
                for (int x = -N; x <= N; x++) {
                    if (Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow(N, 2)) {
                        total++;
                    }
                }
            }
            sb.append(String.format("#%d %d\n", i, total));
        }

        System.out.println(sb);
    }
}
