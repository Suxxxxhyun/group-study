package baekjun.BinarySearch;

//~8:10
//랜선의 길이를 x라고 하였을떄, n개의 랜선을 만들 수 있는가? 없는가?
import java.io.*;
import java.util.*;

public class Main165402 {
	
	static StringTokenizer st;
	static int k,n;
	static int[] a;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		a = new int[k];
		for(int i=0; i<k; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		pro();

	}
	
	static void pro() {
		long L = 1, R = Integer.MAX_VALUE, ans = 0;
		while(L <= R) {
			long mid = (L + R) / 2;
			if(determination(mid)) {
				L = mid + 1;
				ans = mid;
			} else {
				R = mid - 1;
			}
		}
		System.out.println(ans);
	}
	
	static boolean determination(long x) {
		long sum = 0;
		for(int i=0; i<a.length; i++) {
			if(a[i] < x) {
				continue;
			}
			sum += a[i] / x;
		}
		return (sum >= n) ? true : false;
	}

}
