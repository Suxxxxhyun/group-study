package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_10726_230516 {
    static int T, N;
    static String M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.toBinaryString(Integer.parseInt(st.nextToken()));

            if (M.length() < N) {
                sb.append(String.format("#%d %s\n", i, "OFF"));
                continue;
            }

            String str = M.substring(M.length() - N, M.length());
            if (str.contains("0")) sb.append(String.format("#%d %s\n", i, "OFF"));
            else sb.append(String.format("#%d %s\n", i, "ON"));

        }
        System.out.println(sb);
    }
}
