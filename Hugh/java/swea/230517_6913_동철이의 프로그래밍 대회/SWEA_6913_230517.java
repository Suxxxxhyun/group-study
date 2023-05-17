package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_6913_230517 {
    static int T, N, M;
    static ArrayList<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            int max = Integer.MIN_VALUE;
            list = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                int cnt = 0;
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    int exam = Integer.parseInt(st.nextToken());
                    if (exam == 1) cnt++;
                }
                list.add(cnt);
                max = Math.max(max, cnt);
            }

            int result = 0;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) == max) result++;
            }

            sb.append(String.format("#%d %d %d\n", i, result, max));
        }
        System.out.println(sb);
    }
}
