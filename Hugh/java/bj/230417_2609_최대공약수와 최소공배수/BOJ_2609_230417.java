package BOJ.Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2609_230417 {
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sb.append(GCD(N, M)).append("\n").append(LCM(N, M));
        System.out.println(sb);
    }

    // 최대공약수
    static int GCD(int N, int M) {
        if (N % M == 0) {
            return M;
        } else {
            return GCD(M,N % M);
        }
    }

    static int LCM(int N, int M) {

        return (N * M) / GCD(N, M);
    }

}
