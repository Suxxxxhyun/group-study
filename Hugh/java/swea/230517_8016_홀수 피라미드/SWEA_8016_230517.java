package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_8016_230517 {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            long N = Integer.parseInt(br.readLine());
            long lay = (2 * N) - 1;

            long front = ((2 * (N * N)) - (4 * N)) + 3;
            long end = front + ((lay - 1) * 2);

            sb.append(String.format("#%d %d %d\n", i, front, end));
        }
        System.out.println(sb);
    }
}
