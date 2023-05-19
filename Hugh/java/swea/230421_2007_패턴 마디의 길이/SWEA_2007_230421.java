package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_2007_230421 {
    static int T;
    static int num = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String str = br.readLine();
            for (int i = 1; i <= str.length(); i++) {
                String s1 = str.substring(0, i);
                String s2 = str.substring(i, i * 2);

                if (s1.equals(s2)) {
                    sb.append("#" + num + " " + s1.length()).append("\n");
                    num++;
                    break;
                }
            }

        }

        System.out.println(sb);
    }
}
