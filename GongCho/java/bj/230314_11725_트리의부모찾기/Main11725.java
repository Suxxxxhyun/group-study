package baekjun.Tree;

import java.io.*;
import java.util.*;
//~10:48
public class Main11725 {
	
	static int n;
	static StringTokenizer st;
	static ArrayList<Integer>[] a;
	static boolean[] visited;
	static int[] parent;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		a = new ArrayList[n+1];
		visited = new boolean[n+1];
		parent = new int[n+1];
		for(int i=1; i<=n; i++) {
			a[i] = new ArrayList<Integer>();
		}
		for(int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			a[b].add(c);
			a[c].add(b);
		}
		bfs(1);
	}
	
	static void bfs(int x) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(x);
		visited[x] = true;
		while(!q.isEmpty()) {
			int node = q.poll();
			for(int i=0; i<a[node].size(); i++) {
				if(!visited[a[node].get(i)]) {
					visited[a[node].get(i)] = true;
					parent[a[node].get(i)] = node;
					q.offer(a[node].get(i));
				}
			}
		}
		
		for(int i=2; i<=n; i++) {
			sb.append(parent[i]).append('\n');
		}
		System.out.println(sb);
	}

}
