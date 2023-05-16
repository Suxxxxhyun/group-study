package BOJ.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14889_230405 {
    static int[][] arr;
    static boolean[] visit;
    static int N;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(min);
    }

    static void dfs(int idx ,int depth) {
        if (depth == N / 2) {

            int start = 0;
            int link = 0;

            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (visit[i] == true && visit[j] == true) {
                        start += arr[i][j];
                        start += arr[j][i];
                    } else if (visit[i] == false && visit[j] == false) {
                        link += arr[i][j];
                        link += arr[j][i];
                    }
                }
            }
            int result = Math.abs(start - link);

            min = Math.min(result, min);

            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(i + 1, depth + 1);

                visit[i] = false;
            }
        }
    }


}
