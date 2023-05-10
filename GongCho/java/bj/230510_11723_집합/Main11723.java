package baekjun.simulation;

//9:00 ~ 9:30
import java.io.*;
import java.util.*;

public class Main11723 {
	
	static int m;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		m = Integer.parseInt(br.readLine());
		
		Set<Integer> set = new HashSet<Integer>();
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String str = st.nextToken();
			if(str.equals("add")) {
				int x = Integer.parseInt(st.nextToken());
				set.add(x);
			} else if(str.equals("remove")) {
				int x = Integer.parseInt(st.nextToken());
				set.remove(x);
			} else if(str.equals("check")) {
				int x = Integer.parseInt(st.nextToken());
				if(set.contains(x)) {
					sb.append(1).append('\n');
				} else {
					sb.append(0).append('\n');
				}
			} else if(str.equals("toggle")) {
				int x = Integer.parseInt(st.nextToken());
				if(set.contains(x)) {
					set.remove(x);
				} else {
					set.add(x);
				}
			} else if(str.equals("empty")){
				set.clear();
			} else {
				set.clear();
				for(int j=1; j<=20; j++) {
					set.add(j);
				}
			}
		}
		System.out.println(sb);
	}

}
