package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1912_230315 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
           arr[i] = Integer.parseInt(st.nextToken());
        }


        /*
         * dp[0]은 첫 원소로 이전에 더이상 탐색할 것이 없기 때문에
         * arr[0] 자체 값이 되므로 arr[0]으로 초기화 해준다.
         * max또한 첫 번째 원소로 초기화 해준다.
         */
        dp[0] = arr[0];
        int max = arr[0];

        for (int i = 1; i < n; i++) {
            // (이전 dp + 현재 arr값) 과 현재 arr값 중 큰 것을 sp에 저장
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            // 최댓값 갱신
            max = Math.max(dp[i], max);
        }

        System.out.println(max);

    }

}
