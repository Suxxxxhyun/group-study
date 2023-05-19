package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6190_230515 {
    static int T, N;
    static int max;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            N = Integer.parseInt(br.readLine());

            // 배열 초기화
            arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            // Ai * Aj 초기화 및 단조 수 판별
            max = Integer.MIN_VALUE;
            for (int j = 0; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    danjo(arr[j] * arr[k]);
                }
            }

            // 가장 큰 수 위해 정렬 및 출력
            if (max == Integer.MIN_VALUE) sb.append(String.format("#%d %d\n", i, -1));
            else sb.append(String.format("#%d %d\n", i, max));
        }
        System.out.println(sb);
    }

    // 단조 수 판별
    static void danjo(int mulNum) {
        String str = String.valueOf(mulNum);
        boolean flag = false;
        for (int z = 0; z < str.length() - 1; z++) {
            if (str.charAt(z) > str.charAt(z + 1)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            max = Math.max(max, mulNum);
        }
    }
}
