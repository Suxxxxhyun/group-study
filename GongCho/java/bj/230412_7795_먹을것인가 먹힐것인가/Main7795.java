package baekjun.BinarySearch;

import java.io.*;
import java.util.*;
//이분탐색의 시간복잡도 확인할것 (log2만 * 2만개)
//logn
public class Main7795 {
	
	static StringTokenizer st;
	static int t,n,m;
	static int[] a, b;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			a = new int[n];
			b = new int[m];
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				a[j] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				b[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(a);
			Arrays.sort(b);
			sb.append(pro()).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static int pro() {
		int cnt = 0;
		for(int i=0; i<a.length; i++) {
			int L = 0, R = b.length - 1, ans = 0;
			while(L <= R) {
				int mid = (L + R) / 2;
				if(determination(mid, a[i])) {
					L = mid + 1;
					ans = mid + 1;
				} else {
					R = mid - 1;
				}
			}
			cnt += ans;
		}
		return cnt;
	}
	
	static boolean determination(int x, int a) {
		if(b[x] >= a) {
			return false;
		} else {
			return true;
		}
	}

}
