package BOJ.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1747_230416 {
    static boolean[] prime = new boolean[1004001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        prime[0] = prime[1] = true;

        for (int i = 2; i * i < prime.length; i++) {
            if (!prime[i]) {
                for (int j = i * i; j < prime.length; j+=i) {
                    prime[j] = true;
                }
            }
        }

        for (int i = N; i < prime.length; i++) {
            if (!prime[i]) {
                String sosu = Integer.toString(i);
                StringBuilder sb = new StringBuilder(sosu);
                if (sosu.equals(sb.reverse().toString())) {
                    System.out.println(Integer.parseInt(sosu));
                    break;
                }

            }
        }
    }
}
