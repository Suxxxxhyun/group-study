package baekjun.src.baekjun.DynamicProgramming;

import java.io.*;
import java.util.*;
public class Main1912 {

    static int n, max = Integer.MIN_VALUE;
    static int[] a, dp;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[n];
        dp[0] = a[0];
        for(int i=1; i<n; i++){
            if(dp[i-1] + a[i] < a[i]) {
                dp[i] = a[i];
            } else {
                dp[i] = dp[i-1] + a[i];
            }
        }
        for(int i=0; i<n; i++){
            //System.out.print(dp[i] + " ");
            max = Math.max(dp[i], max);
        }
        System.out.println(max);
    }
}
