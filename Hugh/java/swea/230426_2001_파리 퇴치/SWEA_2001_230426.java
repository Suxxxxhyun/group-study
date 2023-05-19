package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2001_230426 {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int[][] arr = new int[a][a];

            for (int j = 0; j < a; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < a; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            int max = Integer.MIN_VALUE;
            for (int j = 0; j <= a - b; j++) {

                for (int k = 0; k <= a - b; k++) {
                    int sum = 0;
                    for (int l = 0; l < b; l++) {
                        for (int o = 0; o < b; o++) {
                            sum += arr[j + l][k + o];
                        }
                    }
                    max = Math.max(max, sum);
                }
            }

            sb.append("#" + i + " " + max + "\n");
        }
        System.out.println(sb);

    }
}
