package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1979_230427 {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int numLength = Integer.parseInt(st.nextToken());
            int[][] arr = new int[a][a];

            for (int j = 0; j < a; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < a; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            int total = 0;
            for (int j = 0; j < a; j++) {

                int xCnt = 0;
                int yCnt = 0;

                for (int k = 0; k < a; k++) {
                    // x좌표 카운트
                    if (arr[j][k] == 1) {
                        xCnt++;
                    } else {
                        if (xCnt == numLength) {
                            total++;
                        }
                        xCnt = 0;
                    }

                    // y좌표 카운트
                    if (arr[k][j] == 1) {
                        yCnt++;
                    } else {
                        if (yCnt == numLength) {
                            total++;
                        }
                        yCnt = 0;
                    }
                }
                if (xCnt == numLength) total++;
                if (yCnt == numLength) total++;
            }


            sb.append(String.format("#%d %d\n",  i, total));
        }

        System.out.println(sb);
    }
}
