package baekjun.TowPointers;

import java.io.*;
import java.util.*;

public class Main180603 {
	
	static int n,s;
	static StringTokenizer st;
	static int[] a;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		a = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		pro();
	}
	
	static void pro() {
		int sum = 0, ans = Integer.MAX_VALUE;
		for(int L=0, R=0; L<a.length; L++) {
			while(sum < s && R + 1 <= a.length) {
				sum += a[R];
				R++;
			}
			
			if(sum >= s) {
				ans = Math.min(R - L, ans);
				sum -= a[L];
			}
		}
		System.out.println((ans == Integer.MAX_VALUE) ? 0 : ans);
	}

}
