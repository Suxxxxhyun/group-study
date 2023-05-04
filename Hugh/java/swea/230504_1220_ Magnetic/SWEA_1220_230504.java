package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1220_230504 {
    static int N;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 10; i++) {
            N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N + 1][N + 1];

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {

                    if (arr[j][k] == 1 && inRange(j + 1, k)) {
                        if (arr[j + 1][k] == 2) {
                            cnt++;
                            arr[j + 1][k] = 0;
                        } else {
                            arr[j + 1][k] = 1;
                            arr[j][k] = 0;
                        }
                    }
                }
            }

            sb.append(String.format("#%d %d\n", i, cnt));
            cnt = 0;
        }
        System.out.println(sb);
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}
