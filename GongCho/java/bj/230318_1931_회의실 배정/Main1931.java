package baekjun.sort;

import java.io.*;
import java.util.*;

public class Main1931 {
	
	static int n;
	static StringTokenizer st;
	static int[][] a;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		a = new int[n][2];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			a[i][0] = start;
			a[i][1] = end;
		}
		
		Arrays.sort(a, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
		});
		
		/*for(int i=0; i<a.length; i++) {
			System.out.println(a[i][0] + " " + a[i][1]); 
		}*/
		
		int var = a[0][1];
		int cnt = 1;
		
		for(int i=1; i<a.length; i++) {
			if(var <= a[i][0]) {
				var = a[i][1];
				cnt += 1;
			}
		}
		
		System.out.println(cnt);

	}

}
