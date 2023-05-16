package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class SWEA_1215_230501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 10; i++) {
            int N = Integer.parseInt(br.readLine());

            String[][] arr = new String[8][8];
            for (int j = 0; j < 8; j++) {
                String line = br.readLine();
                for (int k = 0; k < 8; k++) {
                    arr[j][k] = String.valueOf(line.charAt(k));
                }
            }

            int cnt = 0;
            for (int a = 0; a < 8; a++) {
                for (int z = 0; z < 6; z++) {
                    for (int j = z; j < 6; j++) {
                        String strX = "";
                        String strY = "";
                        for (int k = z; k < j + 3; k++) {
                            strX += arr[a][k];
                            strY += arr[k][a];
                        }
                        StringBuilder sb1 = new StringBuilder(strX);
                        StringBuilder sb2 = new StringBuilder(strY);
                        if (strX.equals(sb1.reverse().toString()) && strX.length() == N) {
                            cnt++;
                        }
                        if (strY.equals(sb2.reverse().toString()) && strY.length() == N) {
                            cnt++;
                        }
                    }
                }
            }
            sb.append(String.format("#%d %d\n", i, cnt));
        }
        System.out.println(sb);
    }
}
