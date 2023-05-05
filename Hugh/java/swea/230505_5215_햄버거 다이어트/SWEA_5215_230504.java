package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_5215_230504 {
    static int N, L;
    static int[] jumsu, kcal;
    static boolean[] visited;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            jumsu = new int[N];
            kcal = new int[N];
            visited = new boolean[N];

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                jumsu[j] = Integer.parseInt(st.nextToken());
                kcal[j] = Integer.parseInt(st.nextToken());
            }
            max = Integer.MIN_VALUE;

            dfs(0,0,0);

            sb.append(String.format("#%d %d\n", i, max));
        }
        System.out.println(sb);
    }

    static void dfs(int depth, int s, int k) {
        if (k > L) return;

        if (depth == N) {
            max = Math.max(max, s);
            return;
        }

        dfs(depth + 1, s + jumsu[depth], k + kcal[depth]); // 재료 선택
        dfs(depth + 1, s, k); // 재료 선택 안함
    }
}
