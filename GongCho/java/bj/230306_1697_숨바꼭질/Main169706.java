package baekjun.DFSBFS;

import java.io.*;
import java.util.*;

public class Main169706 {
	
	static StringTokenizer st;
	static int n,k;
	static int[] visited;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		if(n == k) {
			System.out.println(0);
		} else {
			visited = new int[100001];
			System.out.println(bfs(n) - 1);
		}

	}
	
	static int bfs(int x) {
		Queue<Integer> q = new LinkedList<Integer>();
		visited[x] = 1;
		q.offer(x);
		
		while(!q.isEmpty()) {
			int xx = q.poll();
			int nx;
			
			for(int i=0; i<3; i++) {
				if(i == 0) {
					nx = xx - 1;
				} else if(i == 1) {
					nx = xx + 1;
				} else {
					nx = xx * 2;
				}
				
				if(nx == k) {
					return visited[xx] + 1;
				}
				
				if(nx < 0 || nx > 100000 || visited[nx] != 0) {
					continue;
				}
				
				if(visited[nx] == 0) {
					visited[nx] = visited[xx] + 1;
					q.offer(nx);
				}
			}
		}
		return -1;
	}

}
