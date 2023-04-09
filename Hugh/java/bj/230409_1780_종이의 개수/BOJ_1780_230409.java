package BOJ.Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1780_230409 {
    static int[][] arr;
    static int a = 0;
    static int b = 0;
    static int c = 0;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, N);

        sb.append(a).append("\n");
        sb.append(b).append("\n");
        sb.append(c);

        System.out.println(sb);
    }

    static void partition(int row, int col, int size) {
        if (posCheck(row, col, size)) {
            if (arr[row][col] == 1) {
                c++;
            } else if (arr[row][col] == 0) {
                b++;
            } else {
                a++;
            }

            return;
        }

        int newSize = size / 3;
        partition(row, col, newSize);
        partition(row, col + newSize, newSize);
        partition(row, col + 2 * newSize, newSize);

        partition(row + newSize, col, newSize);
        partition(row + newSize, col + newSize, newSize);
        partition(row + newSize, col + 2 * newSize, newSize);


        partition(row + 2 * newSize, col, newSize);
        partition(row + 2 * newSize, col + newSize, newSize);
        partition(row + 2 * newSize, col + 2 * newSize, newSize);
    }

    static boolean posCheck(int row, int col, int size) {
        int pos = arr[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (arr[i][j] != pos) {
                    return false;
                }
            }
        }
        return true;
    }
}
