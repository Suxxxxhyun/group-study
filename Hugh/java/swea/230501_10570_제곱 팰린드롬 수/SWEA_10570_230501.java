package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_10570_230501 {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int cnt = 0;
            for (int j = a; j <= b; j++) {
                if (Math.pow((int)Math.sqrt(j), 2) == j) {
                    String strJ = String.valueOf(j);
                    String sqrtJ = String.valueOf((int)Math.sqrt(j));
                    StringBuilder sb1 = new StringBuilder(strJ);
                    StringBuilder sb2 = new StringBuilder(sqrtJ);
                    if (strJ.equals(sb1.reverse().toString()) && sqrtJ.equals(sb2.reverse().toString())) {
                        cnt++;
                    }
                }
            }
            sb.append(String.format("#%d %d\n", i, cnt));
        }

        System.out.println(sb);
    }
}
