package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5607_230519 {
    static int T, N, R;
    static int MOD = 1234567891;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());

            // N의 Factorial 구하기
            long[] facto = new long[N + 1];
            facto[1] = 1;
            for (int j = 2; j <= N; j++) {
                facto[j] = (facto[j - 1] * j) % MOD;
            }

            long bottom = (facto[R] * facto[N - R]) % MOD; // 페르마의 소정리: R!(N - R)! pow (MOD - 2)
            bottom = pow(bottom, MOD - 2);

            sb.append(String.format("#%d %d\n", i, (facto[N] * bottom) % MOD));
        }
        System.out.println(sb);
    }

    static long pow(long a, int b) { // a의 b승
        if (b == 0) return 1;
        else if (b == 1) return a;

        if (b % 2 == 0) { // b가 짝수인 경우
            long tmp = pow(a, b/2);
            return (tmp * tmp) % MOD;
        }

        long tmp = pow(a, b - 1) % MOD;
        return (tmp * a) % MOD;
    }
}
