package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_11315_230511 {
    static int T, N;
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            N = Integer.parseInt(br.readLine());
            arr = new char[N][N];

            for (int j = 0; j < N; j++) {
                String str = br.readLine();
                for (int k = 0; k < str.length(); k++) {
                    arr[j][k] = str.charAt(k);
                }
            }
            sb.append(String.format("#%d %s\n", i, OmokCheck()));
        }
        System.out.println(sb);
    }

    static String OmokCheck() {
        for (int j = 0; j < N; j++) {
            int rowCnt = 0;
            int colCnt = 0;
            for (int k = 0; k < N; k++) {
                if (arr[j][k] == 'o') rowCnt++;
                else rowCnt = 0;
                if (arr[k][j] == 'o') colCnt++;
                else colCnt = 0;

//                if (rowCnt >= 5 || colCnt >= 5) {
//                    return "YES";
//                }
            }

        }

        int start = 0;
        int end = 0;
        while (start != N) {
            for (int j = end; j < N; j++) {
                int LCnt = 0;
                int RCnt = 0;
                int Ldiag = j;
                int Rdiag = (N - 1) - j;
                for (int k = start; k <= j; k++) {
                    if (arr[k][Ldiag] == 'o') LCnt++;
                    else LCnt = 0;
                    if (arr[k][Rdiag] == 'o') RCnt++;
                    else RCnt = 0;

                    System.out.println(k + " " + Rdiag);
//                    if (LCnt >= 5 || RCnt >= 5) {
//                        return "YES";
//                    }
                    Ldiag--;
                    Rdiag++;
                }
            }
            end = N - 1;
            start++;
        }

        return "NO";
    }
}
