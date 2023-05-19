package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806_230309 {
    static int n, s;
    static int min = Integer.MAX_VALUE;
    static int start = 0;
    static int end = 0;
    static int total = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while(start <= n && end <= n) {
            if(total >= s && min > end - start) min = end - start;

            if(total < s) total += arr[end++];
            else total -= arr[start++];
        }

        if(min == Integer.MAX_VALUE) System.out.println("0");
        else System.out.println(min);

    }
}
