package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6730_230430 {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int pre = arr[0];
            int upMax = 0;
            int downMax = 0;
            for (int j = 1; j < N; j++) {
                if (pre < arr[j]) {
                    if (upMax < arr[j] - pre) {
                        upMax = arr[j] - pre;
                    }
                    pre = arr[j];
                } else if (pre > arr[j]) {
                    if (downMax < pre - arr[j]) {
                        downMax = pre - arr[j];
                    }
                    pre = arr[j];
                }
            }
            sb.append(String.format("#%d %d %d\n", i, upMax, downMax));
        }
        System.out.println(sb);
    }
}
