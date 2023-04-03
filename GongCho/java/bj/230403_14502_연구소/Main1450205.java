package baekjun.DFSBFS;

import java.io.*;
import java.util.*;

public class Main1450205 {
	
	static int n,m, B, cnt = Integer.MIN_VALUE;
	static StringTokenizer st;
	static int[][] map;
	static int[][] blank;
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	static boolean[][] visited;
	static ArrayList<Node> birus = new ArrayList<Node>();
	
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
		map = new int[n][m];
		blank = new int[n*m + 1][2];
		visited = new boolean[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				int a = Integer.parseInt(st.nextToken());
				if(a == 0) {
					B++;
					blank[B][0] = i;
					blank[B][1] = j;
				} else if(a == 2) {
					birus.add(new Node(i,j));
				}
				map[i][j] = a;
			}
		}
		
		pro(1,0);
		System.out.println(cnt);
	}
	
	static void pro(int idx, int cnt) {
		
		if(cnt == 3) {
			/*for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println("--------------------");*/
			ans();
			return;
		}
		
		if(B < idx) {
			return;
		}
		
		map[blank[idx][0]][blank[idx][1]] = 1;
		pro(idx + 1, cnt + 1);
		map[blank[idx][0]][blank[idx][1]] = 0;
		pro(idx + 1, cnt);
	}
	
	static void ans() {
		
		int count = 0;
		Queue<Node> q = new LinkedList<Node>();
		for(int i=0; i<birus.size(); i++) {
			q.offer(birus.get(i));
		}

		while(!q.isEmpty()) {
			Node node = q.poll();
			visited[node.x][node.y] = true;
			
			for(int i=0; i<4; i++) {
				int nx = node.x + dir[i][0];
				int ny = node.y + dir[i][1];
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= m) {
					continue;
				}
				
				if(map[nx][ny] == 1) {
					continue;
				}
				
				if(!visited[nx][ny] && map[nx][ny] == 0) {
					visited[nx][ny] = true;
					//map[nx][ny] = 2;
					q.offer(new Node(nx, ny));
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 0 && !visited[i][j]) {
					count++;
				}
				//System.out.print(map[i][j] + " ");
			}
			//System.out.println();
		}
		
		//System.out.println("--------------------");
		visited = new boolean[n][m];
		cnt = Math.max(cnt, count);
	}

}
