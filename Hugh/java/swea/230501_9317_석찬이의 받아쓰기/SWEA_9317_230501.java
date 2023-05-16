package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_9317_230501 {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            String str1 = br.readLine();
            String str2 = br.readLine();
            int cnt = 0;
            for (int k = 0; k < N; k++) {
                if (str1.charAt(k) != str2.charAt(k)) {
                    cnt++;
                }
            }
            sb.append(String.format("#%d %d\n", i, N - cnt));
        }
        System.out.println(sb);
    }
}
