package baekjun.TowPointers;

import java.io.*;
import java.util.*;

public class Main327302 {
	
	static StringTokenizer st;
	static int n,x;
	static int[] a;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		a = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		x = Integer.parseInt(br.readLine());
		pro();
	}
	
	static void pro() {
		Arrays.sort(a);
		
		int L = 0, R = n-1, cnt = 0;
		while(L < R) {
			int sum = a[L] + a[R];
			if(sum <= x) {
				if(sum == x) {
					cnt++;
				}
				L++;
			} else {
				R--;
			}
		}
		System.out.println(cnt);
	}

}
