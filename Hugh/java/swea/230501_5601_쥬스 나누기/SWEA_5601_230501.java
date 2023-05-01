package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_5601_230501 {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(String.format("#%d ",i));
            for (int j = 0; j < N; j++) {
                sb.append(String.format("1/%d ", N));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
