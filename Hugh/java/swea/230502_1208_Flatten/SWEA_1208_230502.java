package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1208_230502 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 10; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[100];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 100; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            while (N-- >= 0) {
                Arrays.sort(arr);
                if (arr[arr.length - 1] == arr[0] || arr[arr.length - 1] - arr[0] == 1) {
                    break;
                }
                arr[arr.length - 1]--;
                arr[0]++;
            }

            sb.append(String.format("#%d %d\n", i, (arr[arr.length - 1] - arr[0]) + 2));
        }
        System.out.println(sb);
    }
}
