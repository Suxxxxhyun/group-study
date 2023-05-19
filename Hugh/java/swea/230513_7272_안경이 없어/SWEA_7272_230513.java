package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_7272_230513 {
    static int T;
    static String str1, str2;
    static ArrayList<Character> holeAlph = new ArrayList<>(Arrays.asList('A','D','O','P','Q','R'));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            str1 = st.nextToken();
            str2 = st.nextToken();

            if (str1.length() != str2.length()) {
                sb.append(String.format("#%d %s\n", i, "DIFF"));
                continue;
            }

            String convert1 = "";
            String convert2 = "";
            for (int j = 0; j < str1.length(); j++) {
                if (holeAlph.contains(str1.charAt(j))) convert1 += '1';
                else if (str1.charAt(j) == 'B') convert1 += '2';
                else convert1 += '0';

                if (holeAlph.contains(str2.charAt(j))) convert2 += '1';
                else if (str2.charAt(j) == 'B') convert2 += '2';
                else convert2 += '0';
            }

            if (convert1.equals(convert2)) {
                sb.append(String.format("#%d %s\n", i, "SAME"));
            } else {
                sb.append(String.format("#%d %s\n", i, "DIFF"));
            }
        }
        System.out.println(sb);
    }
}
