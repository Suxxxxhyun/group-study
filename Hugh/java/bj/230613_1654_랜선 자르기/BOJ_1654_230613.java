package BOJ.BinarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1654_230613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long[] arr = new long[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        sb.append(bSearch(arr, K, N));
        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }

    static long bSearch(long[] arr, int K, int N) {
        long min = 0;
        long max = arr[K - 1] + 1;

        while (min < max) {
            long mid = (min + max) / 2;
            int cnt = 0;

            for (int i = 0; i < K; i++) {
                cnt += (arr[i] / mid);
            }
            if (cnt < N) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min - 1;
    }
}
