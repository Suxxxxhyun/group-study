package baekjun.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2579 {
	
	static int n;
	static int[] a;
	static int[] dp = new int[301];

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		a = new int[n+1];
		for(int i=1; i<=n; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		pro();
	}
	
	static void pro() {
		dp[1] = a[1];
		
		if(n >= 2) {
			dp[2] = dp[1] + a[2];
		}
		
		for(int i=3; i<=n; i++) {
			dp[i] = Math.max(dp[i-3]+a[i-1], dp[i-2]) + a[i];	
		}
		System.out.println(dp[n]);
	}

}
