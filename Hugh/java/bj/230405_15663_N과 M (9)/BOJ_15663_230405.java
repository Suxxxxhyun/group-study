package BOJ.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15663_230405 {
    static int N,M;
    static int[] exam;
    static int[] result;
    static boolean[] check;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        exam = new int[N];
        result = new int[M];
        check = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            exam[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(exam);

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

        int before = 0;
        for (int i = 0; i < N; i++) {
            if (check[i] == false) {

                if(before != exam[i]) {
                    check[i] = true;
                    result[depth] = exam[i];
                    before = exam[i];
                    dfs(depth + 1);

                    check[i] = false;
                }
            }
        }

    }
}
