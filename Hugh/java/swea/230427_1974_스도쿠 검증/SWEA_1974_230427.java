package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1974_230427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {

            int[][] arr = new int[9][9];
            for (int j = 0; j < 9; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 9; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append(String.format("#%d %d\n", i, sudokuTest(arr)));
        }

        System.out.println(sb);
    }

    static int sudokuTest(int[][] arr) {
        for (int j = 0; j < 9; j++) {
            int totalX = 45;
            int totalY = 45;
            for (int k = 0; k < 9; k++) {
                totalX -= arr[j][k];
                totalY -= arr[k][j];
            }

            if (totalX != 0 || totalY != 0) {
                return 0;
            }
        }

        if (!check33(arr)) {
            return 0;
        }

        return 1;
    }

    // 3*3 체크
    static boolean check33(int[][] arr) {
        int start = 0;
        int end = 3;
        while (start <= 6) {
            int total33 = 45;
            for (int x = start; x < end; x++) {
                for (int y = start; y < end; y++) {
                    total33 -= arr[x][y];
                }
            }
            if (total33 != 0) {
                return false;
            }
            start += 3;
            end += 3;
        }

        return true;
    }
}


