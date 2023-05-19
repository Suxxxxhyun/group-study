package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class SWEA_14178_230514 {
    static int T, N, D;
    static int val, cnt, sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());

            val = (D * 2) + 1;
            cnt = 1;
            while (true) {
                sum = val * cnt;
                if (sum >= N) {
                    break;
                }
                cnt++;
            }

            sb.append(String.format("#%d %d\n", i, cnt));
        }
        System.out.println(sb);
    }
}
