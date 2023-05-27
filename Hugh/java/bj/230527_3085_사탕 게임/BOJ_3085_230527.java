package BOJ.BruteForce;

import java.io.*;

public class BOJ_3085_230527 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        char[][] arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            arr[i] = str.toCharArray();
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j + 1 < N && arr[i][j] != arr[i][j + 1]) {
                    swapCandy(arr, i, j, i, j + 1);
                    ans = Math.max(ans, Math.max(findMaxCol(arr), findMaxRow(arr)));
                    swapCandy(arr, i, j, i, j + 1);
                }
                if (i + 1 < N && arr[i][j] != arr[i + 1][j]) {
                    swapCandy(arr, i, j, i + 1, j);
                    ans = Math.max(ans, Math.max(findMaxCol(arr), findMaxRow(arr)));
                    swapCandy(arr, i, j, i + 1, j);
                }
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();

        bw.close();
        br.close();
    }

    static int findMaxCol(char[][] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int cnt = 1;
            for (int j = 1; j < arr.length; j++) {
                if (arr[j][i] == arr[j - 1][i]) {
                    cnt++;
                } else {
                    max = Math.max(max, cnt);
                    cnt = 1;
                }
            }
            max = Math.max(max, cnt);
        }
        return max;
    }

    static int findMaxRow(char[][] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int cnt = 1;
            for (int j = 1; j < arr.length; j++) {
                if (arr[i][j] == arr[i][j - 1]) {
                    cnt++;
                } else {
                    max = Math.max(max, cnt);
                    cnt = 1;
                }
            }
            max = Math.max(max, cnt);
        }
        return max;
    }

    static void swapCandy(char[][] arr, int x, int y, int x2, int y2) {
        char tmp = arr[x][y];
        arr[x][y] = arr[x2][y2];
        arr[x2][y2] = tmp;
    }
}
