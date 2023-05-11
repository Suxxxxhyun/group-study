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
                for (int k = 0; k < N; k++) {
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

                if (rowCnt >= 5 || colCnt >= 5) {
                    return "YES";
                }
            }

        }

        int Ldiag = 0;
        int Rdiag = 0;
        int Y = N - 1;
        for (int k = 0; k < N; k++) {
            if (arr[k][k] == 'o') Ldiag++;
            else Ldiag = 0;
            if (arr[k][Y] == 'o') Rdiag++;
            else Rdiag = 0;

            if (Ldiag >= 5 || Rdiag >= 5) {
                return "YES";
            }

            Y--;
        }

        for (int j = 0; j < N; j++) {
            for (int k = 0; k < j; k++) {
                if (arr[k][j] == 'o') Ldiag++;
                else Ldiag = 0;
            }

        }

        return "NO";
    }
}
