package BOJ.Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1992_230409 {
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String a = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(a.charAt(j)));
            }
        }

        partition(0, 0, N);

        System.out.println(sb);

    }

    static void partition(int row, int col, int size) {
        if (posCheck(row, col, size)) {
            if (arr[row][col] == 1) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            return;
        }

        int newSize = size / 2;

        partition(row, col, newSize);
        partition(row, col + newSize, newSize);
        partition(row + newSize, col, newSize);
        partition(row + newSize, col + newSize, newSize);
        sb.append(")");
    }

    static boolean posCheck(int row, int col, int size) {
        int pos = arr[row][col]; // 첫 번째 원소 기준 검사

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                // 같지 않다면
                if (arr[i][j] != pos) {
                    sb.append("(");
                    return false;
                }
            }
        }
        // 검사 무사 통과
        return true;
    }
}


