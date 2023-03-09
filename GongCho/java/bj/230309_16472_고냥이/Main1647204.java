package baekjun.TowPointers;

import java.io.*;

public class Main1647204 {
	
	static int n, kind;
	static int[] alph = new int[26];
	static String str;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		str = br.readLine();
		pro();

	}
	
	static void pro() {
		int ans = 0;
		for(int L = 0, R = 0; L < str.length(); L++) {
			add(str.charAt(L));
			
			if(kind > n) {
				remove(str.charAt(R++));
			}
			
			ans = Math.max(ans, L - R + 1);
		}
		System.out.println(ans);
	}
	
	static void add(char a) {
		if(alph[a - 'a'] == 0) {
			kind++;
		}
		alph[a - 'a']++;
	}
	
	static void remove(char a) {
		alph[a - 'a']--;
		if(alph[a - 'a'] ==  0) {
			kind--;
		}
	}

}
