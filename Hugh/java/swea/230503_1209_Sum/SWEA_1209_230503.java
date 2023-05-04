package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1209_230503 {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringBuilder sb = new StringBuilder();

       for (int i = 1; i <= 10; i++) {
           T = Integer.parseInt(br.readLine());
           int[][] arr = new int[101][101];

           for (int j = 0; j < 100; j++) {
               StringTokenizer st = new StringTokenizer(br.readLine());
               for (int k = 0; k < 100; k++) {
                   arr[j][k] = Integer.parseInt(st.nextToken());
               }
           }

           int max = Integer.MIN_VALUE;
           // 행.열
           for (int j = 0; j < 100; j++) {
               int rowSum = 0;
               int colSum = 0;
               for (int k = 0; k < 100; k++) {
                   rowSum += arr[j][k];
                   colSum += arr[k][j];
               }
               max = Math.max(max, Math.max(rowSum, colSum));
           }

           // 대각선
           int diaR = 0;
           int diaL = 0;
           int end = 99;
           for (int j = 0; j < 100; j++) {
               diaR += arr[j][j];
               diaL += arr[end][end];
               end--;
           }
           max = Math.max(max, Math.max(diaR, diaL));

           sb.append(String.format("#%d %d\n", i, max));
       }
        System.out.println(sb);
    }
}
