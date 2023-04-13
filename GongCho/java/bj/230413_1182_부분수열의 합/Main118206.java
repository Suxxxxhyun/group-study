package baekjun.BackTrack;

//7:30 ~ 8:00
import java.io.*;
import java.util.*;

public class Main118206 {
	
	static int n,s,cnt;
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
		pro(0,0);
		if(s == 0) {
			System.out.println(cnt - 1);
		} else {
			System.out.println(cnt);
		}
	}
	
	static void pro(int idx,int sum) {
		
		if(idx == n) {
			if(sum == s) {
				cnt++;
			}
			return;
		}
		
		//고르는 경우
		pro(idx + 1, a[idx] + sum);
		//고르지 않는 경우
		pro(idx + 1, sum);
	}

}
