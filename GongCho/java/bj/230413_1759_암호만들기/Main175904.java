package baekjun.BackTrack;

import java.io.*;
import java.util.*;

public class Main175904 {
	
	static int l,c;
	static StringTokenizer st;
	static char[] a;
	static int[] selected;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		a = new char[c];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<c; i++) {
			a[i] = st.nextToken().charAt(0);
		}
		selected = new int[l];
		Arrays.sort(a);
		pro(0);
		System.out.println(sb);
	}
	
	static void pro(int idx) {
		if(idx == l) {
			if(confirm()) {
				for(int i=0; i<l; i++) {
					sb.append(a[selected[i]]);
				}
				sb.append('\n');
			}
			return;
		}
		
		int start = 0;
		if(idx != 0) {
			start = selected[idx - 1] + 1;
		}
		
		for(int cand = start; cand < c; cand++) {
			selected[idx] = cand;
			pro(idx + 1);
		}
	}
	
	static boolean confirm() {
		int moCount = 0, zaCount = 0;
		for(int i=0; i<l; i++) {
			if(a[selected[i]] == 'a' || a[selected[i]] == 'e' || a[selected[i]] == 'i' || a[selected[i]] == 'o' || a[selected[i]] == 'u') {
				moCount++;
			} else {
				zaCount++;
			}
		}
		if(moCount >= 1 && zaCount >= 2) {
			return true;
		} else {
			return false;
		}
	}

}
