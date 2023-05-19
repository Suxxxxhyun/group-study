package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6692_230516 {
    static int T, N;
    static double P, X;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            N = Integer.parseInt(br.readLine());
            double result = 0;

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                P = Double.parseDouble(st.nextToken());
                X = Double.parseDouble(st.nextToken());
                result += P * X;
            }

            sb.append(String.format("#%d %f\n", i, result));
        }
        System.out.println(sb);
    }
}
