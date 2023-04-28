package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1948_230428 {
    static int T;
    static int[] month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M1 = Integer.parseInt(st.nextToken());
            int D1 = Integer.parseInt(st.nextToken());
            int M2 = Integer.parseInt(st.nextToken());
            int D2 = Integer.parseInt(st.nextToken());

            if (M1 == M2) {
                sb.append(String.format("#%d %d\n", i, (D2 - D1) + 1));
            } else if (M2 - M1 == 1) {
                sb.append(String.format("#%d %d\n", i, ((month[M1] - D1) + 1) + (month[M2] - (month[M2] - D2))));
            } else {
                int FLDays = ((month[M1] - D1) + 1) + (month[M2] - (month[M2] - D2));
                for (int j = M1 + 1; j < M2; j++) {
                    FLDays += month[j];
                }
                sb.append(String.format("#%d %d\n", i, FLDays));
            }

        }

        System.out.println(sb);
    }
}
