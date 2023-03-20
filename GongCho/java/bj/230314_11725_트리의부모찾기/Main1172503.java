package baekjun.Tree;

import java.io.*;
import java.util.*;

public class Main1172503 {

	static int n;
	static StringTokenizer st;
	static ArrayList<Integer>[] graph;
	static int[] parent;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		graph = new ArrayList[n+1];
		parent = new int[n+1];
		for(int i=1; i<=n; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		for(int i=1; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		
		dfs(1, -1);
		for(int i=2; i<=n; i++) {
			sb.append(parent[i]).append('\n');
		}
		System.out.println(sb.toString());

	}
	
	static void dfs(int x, int par) {
		for(int y : graph[x]) {
			if(y == par) {
				continue;
			}
			parent[y] = x;
			dfs(y, x);
		}
	}

}
