package baekjun.sort;

import java.io.*;
import java.util.*;

public class Main193102 {
	
	static int n, ans = 1;
	static Lesson[] a;
	static StringTokenizer st;
	
	static class Lesson{
		int start, end;
		
		public Lesson(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		a = new Lesson[n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			a[i] = new Lesson(s,e);
		}
		
		Arrays.sort(a, new Comparator<Lesson>(){
			public int compare(Lesson l1, Lesson l2) {
				if(l1.end == l2.end) {
					return l1.start - l2.start;
				}
				return l1.end - l2.end;
			}
		});
		
		int f = a[0].end;
		for(int i=1; i<n; i++) {
			if(f <= a[i].start) {
				ans += 1;
				f = a[i].end;
			}
		}
		System.out.println(ans);
	}

}
