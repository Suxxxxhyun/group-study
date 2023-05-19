package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class SWEA_1288_230429 {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            Set<Integer> set = new HashSet<>();
            int cnt = 1;
            while (set.size() != 10) {
                int mulN = N * cnt;
                cnt++;
                String strN = String.valueOf(mulN);
                for (int j = 0; j < strN.length(); j++) {
                    set.add(Integer.parseInt(String.valueOf(strN.charAt(j))));
                }
            }
            sb.append(String.format("#%d %d\n", i, (N * (cnt - 1))));
        }
        System.out.println(sb);
    }
}
