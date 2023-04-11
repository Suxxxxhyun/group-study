package baekjun.TowPointers;

import java.io.*;
import java.util.*;
//일단 지금은 이분탐색으로 풀고
//그리고 나서 투포인터로 다시풀어보기 -> 그냥 투포인터로 풀어보겠음 -> NO
public class Main3273 {
	
	static int n,x, count;
	static int[] a;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		a = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		x = Integer.parseInt(br.readLine());
		pro();
	}

	static void pro() {
		//백만log백만
		Arrays.sort(a);
		//System.out.println(Arrays.toString(a));
		
		for(int i=0; i<a.length; i++) {
			int val = a[i];
			if(val >= x) {
				break;
			}
			if(binarySearch(i+1,val)) {
				//System.out.println("탔음");
				count++;
			};
		}
		System.out.println(count);
	}
	
	static boolean binarySearch(int L, int val) {
		int right = a.length - 1;
		int left = L;
		int find = x - val, ans = -1;
		//System.out.println(find);
		while(left <= right) {
			int mid = (left + right) / 2;
			if(find > a[mid]) {
				left = mid + 1;
			} else if(find == a[mid]) {
				ans = mid;
				break;
			} else {
				right = mid - 1;
			}
		}
		if(ans == -1) {
			return false;
		} else {
			return true;
		}
		//return ans;
	}
}
