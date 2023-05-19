package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7964_230516 {
    static int T, N, D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());

            int cnt = 0;
            int gate = 0;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int brokenGate = Integer.parseInt(st.nextToken());

                if (brokenGate == 1) cnt = 0;
                else {
                    cnt++;
                    if (cnt == D) {
                        gate++;
                        cnt = 0;
                    }
                }
            }
            sb.append(String.format("#%d %d\n", i, gate));
        }
        System.out.println(sb);
    }
}
