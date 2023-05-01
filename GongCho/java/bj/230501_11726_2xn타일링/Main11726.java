package baekjun.DynamicProgramming;

import java.io.*;

public class Main11726 {
	
	static int n;
	static long[] dp = new long[1001];

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		pro();

	}
	
	static void pro() {
		dp[1] = 1;
		dp[2] = 2;
		
		if(n <= 2) {
			System.out.println(dp[n]);
		} else if(n >= 3) {
			for(int i=3; i<=n; i++) {
				dp[i] = (dp[i-1] + dp[i-2]) % 10007;
			}
			System.out.println(dp[n]);
		}
	}

}
