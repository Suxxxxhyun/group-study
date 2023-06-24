package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1744_230624 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int result = 0;

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int left = 0;
        int right = N-1;
        // 음수 곱샘
        for (; left < right; left+=2) {
            if (arr[left] < 1 && arr[left+1] < 1) result += arr[left] * arr[left+1];
            else break;
        }

        // 양수 곱샘
        for (; right > 0; right-=2) {
            if (arr[right] > 1 && arr[right-1] > 1) result += arr[right] * arr[right-1];
            else break;
        }

        // 나머지 더해주기
        for (; right >= left; right--) {
            result += arr[right];
        }

        sb.append(result);
        System.out.println(sb);
    }
}
