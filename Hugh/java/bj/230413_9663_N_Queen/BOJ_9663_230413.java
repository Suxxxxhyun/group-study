package BOJ.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9663_230413 {
    static int N;
    static int[] arr;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        dfs(0);
        System.out.println(cnt);
    }
    static void dfs(int depth) {
        if (depth == N) {
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i;

            if (Possibility(depth)) {
                dfs(depth + 1);
            }
        }
    }

    static boolean Possibility(int col) {

        for (int i = 0; i < col; i++) {
            // 같은 행에 존재하는 경우
            if (arr[col] == arr[i]) {
                return false;
            }
            // 대각선상에 놓여있는 경우
            // (열의 차 == 행의 차) = 대각선에 놓인 경우
            else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }

        return true;
    }
}
