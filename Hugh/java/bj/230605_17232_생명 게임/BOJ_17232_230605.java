package BOJ.DP;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_17232_230605 {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        char[][] arr = new char[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= M; j++) {
                arr[i][j] = str.charAt(j - 1);
            }
        }

        while (T-- > 0) {

            int[][] arrCnt = getPrefixSum(arr);
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    int nearAlive = getRangeSum(arrCnt, i, j, K);

                    // 생명이 있다.
                    if (arr[i][j] == '*') {
                        nearAlive--;
                        if (nearAlive < a || nearAlive > b) arr[i][j] = '.';
                    }
                    // 생명이 없다.
                     else if (nearAlive > a && nearAlive <= b) arr[i][j] = '*';
                }
            }

        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }
    static int[][] getPrefixSum(char[][] arr) {
        int[][] arrCnt = new int[arr.length][arr[0].length];
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                arrCnt[i][j] = arrCnt[i - 1][j] + arrCnt[i][j - 1] - arrCnt[i - 1][j - 1]
                                + (arr[i][j] == '*' ? 1 : 0);
            }
        }

        return arrCnt;
    }

    static int getRangeSum(int[][] arrCnt, int x, int y, int K) {
        int x1 = Math.max(x - K, 1);
        int y1 = Math.max(y - K, 1);
        int x2 = Math.min(x + K, arrCnt.length - 1);
        int y2 = Math.min(y + K, arrCnt[0].length - 1);

        return arrCnt[x2][y2] - arrCnt[x1 - 1][y2] - arrCnt[x2][y1 - 1] + arrCnt[x1 - 1][y1 - 1];
    }
}
