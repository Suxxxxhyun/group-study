package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_11047_230327 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long K = Integer.parseInt(st.nextToken());

        Long[] arr = new Long[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr, Collections.reverseOrder());

        int cnt = 0;
        for(long x:arr){
            if(x <= K) {
                cnt += (K / x);
            }
            K = K % x;
        }

        System.out.println(cnt);

    }
}
