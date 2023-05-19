package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1970_230427 {
    static int T;
    static int[] cost = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int[] arr = new int[8];
            int N = Integer.parseInt(br.readLine());

            sb.append("#" + i + "\n");
            for (int j = 0; j < 8; j++) {
                arr[j] = N / cost[j];
                N -= (N / cost[j]) * cost[j];
                sb.append(arr[j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
