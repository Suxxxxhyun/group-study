package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_2806_230502 {
    static int T;
    static int cnt = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            arr = new int[N];

            dfs(0, N);
            sb.append(String.format("#%d %d\n", i, cnt));
            cnt = 0;
        }
        System.out.println(sb);
    }

    static void dfs(int depth, int N) {
        if (depth == N) {
            cnt++;
            return;
        }
        for (int i = 0; i < N; i++) {
            arr[depth] = i;

            // 가능성 파악 (백트레킹)
            if (Possibility(depth)) {
                dfs(depth + 1, N);
            }
        }
    }

    static boolean Possibility(int depth) {
        for (int i = 0; i < depth; i++) {

            // 같은 행
            if (arr[depth] == arr[i]) {
                return false;
            }
            // 열의 차 == 행의 차 = 같은 대각선
            else if (Math.abs(depth - i) == Math.abs(arr[depth] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}
