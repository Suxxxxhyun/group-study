package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2805_230326 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N= Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());

        long[] arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        System.out.println(UpperBound(M, arr));

    }
    static long UpperBound(long M, long[] arr) {
        long min = 0;
        long max = arr[arr.length - 1] + 1;
        while(min < max) {
            long cnt = 0;
            long mid = (max + min) / 2;
            for(int i = 0; i < arr.length; i++) {
                if((arr[i] - mid) > 0) {
                    cnt += (arr[i] - mid);
                }
            }
            if(cnt < M) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min - 1;
    }
}
