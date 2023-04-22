package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_2005_230421 {
    static int T;
    static int num = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];

            sb.append("#" + num + " \n");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= i; j++) {
                    if (j == 0 || j == i) {
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = (arr[i - 1][j - 1] + arr[i - 1][j]);
                    }

                    sb.append(arr[i][j] + " ");
                }
                sb.append("\n");
            }

            num++;
        }

        System.out.println(sb);

    }
}
