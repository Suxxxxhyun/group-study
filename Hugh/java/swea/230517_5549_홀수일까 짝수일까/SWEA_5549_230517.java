package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class SWEA_5549_230517 {
    static int T;
    static BigInteger num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            num = new BigInteger(br.readLine());
            if (num.remainder(BigInteger.valueOf(2)) == BigInteger.valueOf(0)) {
                sb.append(String.format("#%d %s\n", i, "Even"));
            } else {
                sb.append(String.format("#%d %s\n", i, "Odd"));
            }
        }
        System.out.println(sb);
    }
}
