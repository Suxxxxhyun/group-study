package BOJ.Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2630_230409 {
    static int white = 0;
    static int blue = 0;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        board  = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, N);

        sb.append(white).append("\n").append(blue);
        System.out.println(sb);
    }

    static void partition (int row, int col, int size) {
        if (colorCheck(row, col, size)) {
            if (board[row][col] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }

        int newSize = size / 2;

        partition(row, col, newSize);
        partition(row, col + newSize, newSize);
        partition(row + newSize, col, newSize);
        partition(row + newSize, col + newSize, newSize);
    }

    static boolean colorCheck(int row, int col, int size) {
        int color = board[row][col]; // 첫 번째 원소를 기준으로 검사

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                // 색상이 같지 않다면
                if (board[i][j] != color) {
                    return false;
                }
            }
        }
        // 검사 모두 통과
        return true;
    }
}
