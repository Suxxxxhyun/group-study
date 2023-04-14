package baekjun.String;

//10:30 ~ 10:40
import java.io.*;
import java.util.*;

public class Main1157 {
	
	static int[] a = new int[26];

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		str = str.toUpperCase();
		for(int i=0; i<str.length(); i++) {
			int num = str.charAt(i) - 'A';
			a[num]++;
		}
		
		int max = 0;
		char answer = '?';
		for(int i=0; i<26; i++) {
			if(max < a[i]) {
				max = a[i];
				answer = (char)(i + 'A');
			} else if(max == a[i]) {
				answer = '?';
			}
		}
		System.out.println(answer);
	}

}

