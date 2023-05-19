package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_4406_230430 {
    static int T;
    static String[] mo = {"a","e","i","o","u"};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            String N = br.readLine();
            for (int j = 0; j < 5; j++) {
                if (N.contains(mo[j])) {
                    N = N.replaceAll(mo[j], "");
                }
            }
            sb.append(String.format("#%d %s\n", i, N));
        }
        System.out.println(sb);
    }
}
