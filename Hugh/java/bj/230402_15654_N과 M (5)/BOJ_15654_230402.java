package BOJ.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15654_230402 {
    static int N, M;
    static int[] example;
    static int[] result;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        example = new int[N];
        visit = new boolean[N];
        result = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            example[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(example);
        dfs(0);
        System.out.println(sb);
    }

    static void dfs(int depth) {
        if (depth == M) {
            for (int val : result) {
                sb.append(val + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < N; i++) {
            if(visit[i] == false) {
                visit[i] = true;
                result[depth] = example[i];
                dfs(depth + 1);

                visit[i] = false;
            }

        }
    }
}
