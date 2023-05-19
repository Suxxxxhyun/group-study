package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_5356_230510 {
    static int T;
    static char[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            dp = new char[15][15];

            for (int j = 0; j < 5; j++) {
                String str = br.readLine();
                for (int k = 0; k < str.length(); k++) {
                    dp[k][j] = str.charAt(k);
                }
            }

            sb.append(String.format("#%d ", i));
            for (int j = 0; j < 15; j++) {
                for (int k = 0; k < 15; k++) {
                    if ('\0' != dp[j][k]) {
                        sb.append(dp[j][k]);
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
