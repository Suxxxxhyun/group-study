package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2817_230508 {
    static int T, N, K;
    static int[] arr;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = new int[N];
            cnt = 0;

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);
            sb.append(String.format("#%d %d\n", i, cnt));
        }
        System.out.println(sb);
    }
    static void dfs(int depth, int sum) {
        if (depth == N) {
            if (sum == K) cnt++;
            return;
        }

        // 포함 할 때
        dfs(depth + 1, sum + arr[depth]);
        // 포함 안할 때
        dfs(depth + 1, sum);
    }
}
