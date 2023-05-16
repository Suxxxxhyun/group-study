package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1289_230430 {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            String N = br.readLine();
            StringBuilder sb1 = new StringBuilder(N);
            int cnt = 0;

            while (true) {
                if (!N.contains("1")) {
                    break;
                }
                for (int j = 0; j < N.length(); j++) {
                    if (N.charAt(j) == '1') {
                        for (int k = j; k < N.length(); k++) {
                            if (N.charAt(k) == '0') {
                                sb1.setCharAt(k, '1');
                                N = sb1.toString();
                            } else {
                                sb1.setCharAt(k, '0');
                                N = sb1.toString();
                            }
                        }
                        break;
                    }
                }
                cnt++;
            }

            sb.append(String.format("#%d %d\n", i, cnt));
        }
        System.out.println(sb);
    }
}
