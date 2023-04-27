package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1976_230427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H1 = Integer.parseInt(st.nextToken());
            int M1 = Integer.parseInt(st.nextToken());
            int H2 = Integer.parseInt(st.nextToken());
            int M2 = Integer.parseInt(st.nextToken());

            int totalH = (H1 + H2);
            int totalM = (M1 + M2);
            if (totalM >= 60) {
                totalH += 1;
                totalM -= 60;
            }
            if (totalH > 12) {
                totalH -= 12;
            }
            sb.append(String.format("#%d %d %d\n", i, totalH, totalM));
        }

        System.out.println(sb);
    }
}
