package baekjun.DFSBFS;

import java.io.*;
import java.util.*;

public class Main217803 {
	
	static int n,m;
	static int[][] graph;
	static boolean[][] visited;
	static StringTokenizer st;
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	static class Node{
		int x, y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph = new int[n+1][m+1];
		for(int i=1; i<=n; i++) {
			String str = br.readLine();
			for(int j=1; j<=m; j++) {
				graph[i][j] = str.charAt(j-1) - '0';
			}
		}
		visited = new boolean[n+1][m+1];
		
		bfs(1,1);
	}
	
	static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(x,y));
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = node.x + dir[i][0];
				int ny = node.y + dir[i][1];
				
				if(nx <= 0 || ny <= 0 || nx > n || ny > m) {
					continue;
				}
				
				if(graph[nx][ny] == 1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					graph[nx][ny] = graph[node.x][node.y] + 1;
					q.offer(new Node(nx, ny));
				}
			}
		}
		
		System.out.println(graph[n][m]);
	}

}
