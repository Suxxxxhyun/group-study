package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Base64;

public class SWEA_1928_230429 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            String str = br.readLine();
            byte[] ba = Base64.getDecoder().decode(str);
            sb.append(String.format("#%d ", i));
            for (int j = 0; j < ba.length; j++) {
                sb.append((char)ba[j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
