package baekjun.DFSBFS;

import java.io.*;
import java.util.*;

//8:04 ~ 8:40 인구이동 복습 시작
public class Main1623406 {
	
	static int n,L,R,sum, total_day;
	static int[][] map;
	static boolean[][] visited;
	static StringTokenizer st;
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	static ArrayList<Node> list;
	
	static class Node{
		int x, y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public String toString() {
			return "[" + x + "," + y + "]";
		}
	}

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		pro();

	}
	
	static void pro() {
		while(true) {
			boolean isEnd = false;
			visited = new boolean[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(!visited[i][j]) {
						bfs(i,j);
						
						//System.out.println(list);
						if(list.size() > 1) {
							move();
							isEnd = true;
						}
						
						sum = 0;
					}
				}
			}
			
			if(!isEnd) {
				break;
			}
			total_day++;
		}
		System.out.println(total_day);
	}
	
	static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(x,y));
		visited[x][y] = true;
		list = new ArrayList<Node>();
		list.add(new Node(x,y));
		sum += map[x][y];
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = node.x + dir[i][0];
				int ny = node.y + dir[i][1];
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= n) {
					continue;
				}
				
				if(visited[nx][ny]) {
					continue;
				}
				
				int val = Math.abs(map[nx][ny] - map[node.x][node.y]);
				if((val >= L && val <= R) && !visited[nx][ny]) {
					visited[nx][ny] = true;
					q.offer(new Node(nx,ny));
					list.add(new Node(nx,ny));
					sum += map[nx][ny];
				}
			}
			
		}
 	}
	
	static void move() {
		//System.out.println(sum);
		int avg = sum / list.size();
		
		for(Node n : list) {
			map[n.x][n.y] = avg;
		}
		
		/*for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("==============");*/
	}

}
