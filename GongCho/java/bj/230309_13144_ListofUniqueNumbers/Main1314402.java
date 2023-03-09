package baekjun.TowPointers;

import java.io.*;
import java.util.*;

public class Main1314402 {
	
	static int n;
	static int[] a;
	static StringTokenizer st;
	static int[] visited = new int[100001];

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		a = new int[n+1];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=1; i<=n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		pro();
	}
	
	static void pro() {
		long ans = 0, cnt = 0;
		for(int L=1, R=1; L<a.length; L++) {
			while(R + 1 <= a.length && visited[a[R]] == 0) {
				visited[a[R]]++;
				R++;
			}
			
			ans = R - L;
			//System.out.println(ans);
			cnt += ans;
			visited[a[L]]--;
		}
		System.out.println(cnt);
	}
}
