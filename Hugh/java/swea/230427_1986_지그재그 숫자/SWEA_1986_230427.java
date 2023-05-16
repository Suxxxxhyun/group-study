package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1986_230427 {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            int n = Integer.parseInt(br.readLine());

            sb.append("#" + i + " " + zigzag(n) + "\n");

        }

        System.out.println(sb);
    }

    static int zigzag(int n) {

        int sum = 1;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                sum -= i;
            } else {
                sum += i;
            }
        }

        return sum;
    }
}
