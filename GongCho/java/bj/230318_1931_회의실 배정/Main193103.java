package baekjun.sort;

import java.io.*;
import java.util.*;

public class Main193103 {
	
	static int n, ans = 1;
	static int[][] a;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		a = new int[n][2];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			a[i][0] = s;
			a[i][1] = e;
		}
		
		Arrays.sort(a, new Comparator<int[]>(){
			public int compare(int[] l1, int[] l2) {
				if(l1[1] == l2[1]) {
					return l1[0] - l2[0];
				}
				return l1[1] - l2[1];
			}
		});
		
		int f = a[0][1];
		for(int i=1; i<n; i++) {
			if(f <= a[i][0]) {
				ans += 1;
				f = a[i][1];
			}
		}
		System.out.println(ans);
	}

}
