package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2805_230412 {
    static int N;
    static long M;
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());

        arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        System.out.println(UpperBound());
    }

    static long UpperBound() {
        long min = 0;
        long max = arr[N - 1] + 1;

        while (min < max) {
            long mid = (min + max) / 2;

            long cnt = 0;
            for (int i = 0; i < N; i++) {
                if ((arr[i] - mid) > 0) {
                    cnt += arr[i] - mid;
                }
            }

            if (cnt < M) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        return min - 1;
    }


}
