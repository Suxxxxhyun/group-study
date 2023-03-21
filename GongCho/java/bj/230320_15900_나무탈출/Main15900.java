package baekjun.Tree;

import java.io.*;
import java.util.*;

//~ 11:00
public class Main15900 {
	
	static int n, sum;
	static ArrayList<Integer>[] graph;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		graph = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		
		dfs(1,-1, 0);
		
		if(sum % 2 == 0) {
			System.out.println("No");
		} else {
			System.out.println("Yes");
		}
	}
	
	static void dfs(int x, int par, int depth) {
		
		if(graph[x].size() == 1 && x != 1) {
			sum += depth;
			return;
		}
		
		for(int y : graph[x]) {
			if(y == par) {
				continue;
			}
			
			dfs(y, x, depth + 1);
		}
	}

}
