package baekjun.TowPointers;

//2:46 ~ 3:05
import java.io.*;

public class Main1647206 {
	
	static int n, kind, ans = Integer.MIN_VALUE;
	static String str;
	static int[] a = new int[26];

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		str = br.readLine();
		pro();
		System.out.println(ans);
	}
	
	static void pro() {
		for(int L = 0, R = 0; R < str.length(); R++) {
			add(str.charAt(R));
			
			if(kind > n) {
				erase(str.charAt(L++));
			}
			
			ans = Math.max(ans, R - L + 1);
		}
	}
	
	static void add(char x) {
		a[x - 'a']++;
		if(a[x - 'a'] == 1) {
			kind++;
		}
	}
	
	static void erase(char x) {
		a[x - 'a']--;
		if(a[x - 'a'] == 0) {
			kind--;
		}
	}

}
