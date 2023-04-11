package baekjun.BinarySearch;

import java.io.*;
import java.util.*;

public class Main2805 {
	
	static int n,m;
	static StringTokenizer st;
	static int[] a;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		pro();
	}
	
	static void pro() {
		long L = 0, R = 1000000000, ans = 0;
		while(L <= R) {
			long mid = (L + R) / 2;
			
			if(determination(mid)) {
				L = mid + 1;
				ans = mid;
			} else {
				R = mid - 1;
			}
		}
		System.out.println(ans);
	}
	
	static boolean determination(long h) {
		long sum = 0;
		
		for(int i=0; i<a.length; i++) {
			if(h <= a[i]) {
				sum += a[i] - h;
			}
		}
		
		return sum >= m;
	}

}
