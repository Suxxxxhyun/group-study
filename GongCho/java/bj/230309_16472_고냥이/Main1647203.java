package baekjun.TowPointers;

import java.io.*;

public class Main1647203 {
	
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
		for(int L = 0,R=0; R<str.length(); R++) {
			add(str.charAt(R));
			
			if(kind > n) {
				remove(str.charAt(L++));
				//System.out.println(ans);
			}
			ans = Math.max(R - L + 1, ans);
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
