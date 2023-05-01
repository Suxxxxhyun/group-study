package baekjun.DynamicProgramming;

import java.io.*;

public class Main9095 {
	
	static int t,n;
	static int[] dp;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		dp = new int[11];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int i=4; i<=10; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		for(int i=0; i<t; i++) {
			n = Integer.parseInt(br.readLine());
			sb.append(dp[n]).append('\n');
		}
		System.out.println(sb);

	}

}
