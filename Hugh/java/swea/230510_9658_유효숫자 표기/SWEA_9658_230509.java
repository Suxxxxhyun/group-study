package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_9658_230509 {
    static int T;
    static String str;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            str = br.readLine();
            N = str.length() - 1;
            if (str.substring(0, 2).equals("99") && str.charAt(2) >= '5') {
                N += 1;
                sb.append(String.format("#%d %s\n", i, "1.0*10^" + N));
            } else {
                if (str.charAt(2) >= '5') {
                    int a = Integer.parseInt(str.substring(0, 2)) + 1;
                    sb.append(String.format("#%d %s\n", i, (a / 10) + "." + (a % 10) + "*10^" + N));
                } else {
                    int a = Integer.parseInt(str.substring(0, 2));
                    sb.append(String.format("#%d %s\n", i, (a / 10) + "." + (a % 10) + "*10^" + N));
                }
            }

        }
        System.out.println(sb);
    }
}
