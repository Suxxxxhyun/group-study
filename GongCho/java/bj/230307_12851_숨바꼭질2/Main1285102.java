package baekjun.DFSBFS;

import java.io.*;
import java.util.*;

public class Main1285102 {
	
	static int n,k,cnt,ans = Integer.MAX_VALUE;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] visited = new int[100001];

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		if(n == k) {
			sb.append(0).append('\n');
			sb.append(1);
			System.out.println(sb);
		} else {
			bfs();
			sb.append(ans).append('\n');
			sb.append(cnt).append('\n');
			System.out.println(sb);
		}
	}
	
	static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(n);
		visited[n] = 1;
		//System.out.println("ÅÀÀ½");
		
		while(!q.isEmpty()) {
			int x = q.poll();
			
			if(visited[x] > ans) {
				return;
			}
			
			int nx;
			for(int i=0; i<3; i++) {
				if(i == 0) {
					nx = x - 1;
				} else if(i == 1) {
					nx = x + 1;
				} else {
					nx = x * 2;
				}
				
				if(nx == k) {
					cnt += 1;
					ans = visited[x];
				}
				
				if((nx >= 0 && nx <= 100000) && (visited[nx] == 0 || visited[nx] == visited[x] + 1)) {
					visited[nx] = visited[x] + 1;
					q.offer(nx);
					//System.out.println(nx);
				}
			}
		}
	}

}
