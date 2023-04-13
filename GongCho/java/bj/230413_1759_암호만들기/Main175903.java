package baekjun.BackTrack;

//7:52 ~ 8:20
import java.util.*;
import java.io.*;

public class Main175903 {
	
	static int l,c;
	static StringTokenizer st;
	static char[] a;
	static Num[] selected;
	static StringBuilder sb = new StringBuilder();
	static class Num{
		int index;
		char alpha;
		
		public Num(int index, char alpha) {
			this.index = index;
			this.alpha = alpha;
		}
	}

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		a = new char[c];
		for(int i=0; i<c; i++) {
			a[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(a);
		selected = new Num[l];
		//a, c, i, s, t, w
		pro(0,0);
		System.out.println(sb);
	}
	
	//처음엔 start변수를 통해 이전의 고른것보다 +1하는 방식으로 하려고 하였으나,
	//selected가 char형이다보니, 할 수 가 없음.
	static void pro(int idx, int cnt) {
		if(cnt == l) {
			if(confirm()) {
				for(int i=0; i<l; i++) {
					sb.append(selected[i].alpha);
				}
				sb.append('\n');
			};
			return;
		}
		
		int start = 0;
		if(idx != 0) {
			start = selected[idx-1].index + 1;
		}
		
		for(int cand = start; cand < c; cand++) {
			selected[idx] = new Num(cand, a[cand]);
			pro(idx + 1, cnt + 1);
		}
	}
	
	static boolean confirm() {
		int Mocnt = 0, Zacnt = 0;
		
		for(int i=0; i<l; i++) {
			if(selected[i].alpha == 'a' || selected[i].alpha == 'e' || selected[i].alpha == 'i' || selected[i].alpha == 'o' || selected[i].alpha == 'u') {
				Mocnt += 1;
			} else {
				Zacnt += 1;
			}
		}
		
		if(Mocnt >= 1 && Zacnt >= 2) {
			return true;
		} else {
			return false;
		}
	}
}
