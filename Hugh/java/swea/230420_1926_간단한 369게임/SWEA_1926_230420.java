package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1926_230420 {
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ThreeSixNine(N);

        System.out.println(sb);
    }

    static void ThreeSixNine(int N) {
        for (int i = 1; i <= N; i++) {
            if (i / 100 == 3 || i / 100 == 6 || i / 100 == 9) {
                sb.append("- ");
                if (i / 10 == 3 || i / 10 == 6 || i / 10 == 9) {
                    sb.setLength(sb.length() - 1);
                    sb.append("- ");
                    if (i % 10 == 3 || i % 10 == 6 || i % 10 == 9) {
                        sb.setLength(sb.length() - 1);
                        sb.append("- ");
                    }
                }
                continue;
            } else if (i / 10 == 3 || i / 10 == 6 || i / 10 == 9) {
                sb.append("- ");
                if (i % 10 == 3 || i % 10 == 6 || i % 10 == 9) {
                    sb.setLength(sb.length() - 1);
                    sb.append("- ");
                }
                continue;
            } else if (i % 10 == 3 || i % 10 == 6 || i % 10 == 9) {
                sb.append("- ");
                continue;
            }

            sb.append(i + " ");

        }
    }
}
