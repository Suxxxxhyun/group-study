package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1244_230519 {
    static int T, M, max;
    static char[] N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = st.nextToken().toCharArray();
            M = Integer.parseInt(st.nextToken());

            if (N.length < M) {
                M = N.length;
            }

            max = Integer.MIN_VALUE;
            dfs(0);

            sb.append(String.format("#%d %d\n", i, max));
        }
        System.out.println(sb);
    }

    static void dfs(int val) {
        if (val == M) {
            String result = "";
            for (char x : N) {
                result += x;
            }
            int num = Integer.parseInt(result);
            max = Math.max(max, num);

        } else {
            for (int i = 0; i < N.length - 1; i++) {
                for (int j = i + 1; j < N.length; j++) {
                    swap(i, j);
                    dfs(val + 1);
                    swap(i, j);
                }
            }
        }
    }
    static void swap(int a, int b) {
        char ch = N[a];
        N[a] = N[b];
        N[b] = ch;
    }
}
