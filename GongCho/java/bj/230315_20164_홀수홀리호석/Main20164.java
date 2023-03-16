package baekjun.simulation;

import java.io.*;

public class Main20164 {
	
	static int n, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		cut(n, getOdd(n));
		System.out.println(min + " " + max);
	}
	
	static void cut(int x, int total) {
		if(x < 10) {
			min = Math.min(total, min);
			max = Math.max(total, max);
		} else if(x < 100) {
			int sum = (x / 10) + (x % 10);
			cut(sum, total + getOdd(sum));
		} else {
			String st = Integer.toString(x);
			int len = st.length();
			for(int i=0; i<=len-3; i++) {
				for(int j=i+1; j<=len-2; j++) {
					String s1 = st.substring(0,i+1);
					String s2 = st.substring(i+1,j+1);
					String s3 = st.substring(j+1,len);
					
					int sum = Integer.parseInt(s1) + Integer.parseInt(s2) + Integer.parseInt(s3);
					
					cut(sum, total + getOdd(sum));
				}
			}
		}
	}
	
	static int getOdd(int x) {
		int cnt = 0;
		while(x > 0) {
			int val = x % 10;
			if(val % 2 == 1) {
				cnt++;
			}
			x /= 10;
		}
		return cnt;
	}

}
