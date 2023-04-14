package baekjun.TowPointers;

//2:30 ~ 3:00
import java.io.*;
import java.util.*;

public class Main327304 {
	
	static int n,x,cnt;
	static int[] a;
	static StringTokenizer st;
	//[1,2,3,5,7,9,10,11,12]
	//[1,2,3,4,5,12,14,16]

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		a = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		x = Integer.parseInt(br.readLine());
		Arrays.sort(a);
		pro();
	}
	
	static void pro() {
		/*for(int L=0, R=a.length-1; L<R;) {
			if(a[L] + a[R] < x) { 
				L++;
			} else {
				if(a[L] + a[R] == x) {
					cnt++;
				}
				R--;
			}
		}*/
		int L = 0, R = a.length - 1;
		while(L < R) {
			if(a[L] + a[R] < x) { 
				L++;
			} else {
				if(a[L] + a[R] == x) {
					cnt++;
				}
				R--;
			}
		}
		System.out.println(cnt);
	}

}
