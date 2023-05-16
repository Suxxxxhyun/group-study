package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1989_230426 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            String str = br.readLine();
            StringBuilder sb2 = new StringBuilder(str);
            String reverseStr = sb2.reverse().toString();

            if (str.equals(reverseStr)) {
                System.out.println("#" + i + " " + 1);
            } else {
                System.out.println("#" + i + " " + 0);

            }
        }
    }
}
