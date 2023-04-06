package baekjun.DFSBFS;

//~10:35까지 끊고 갈것.
//걍 근처부터 확인하기 위해 BFS로 돌려보자.
//답보고 살짝 감잡음 생각해보니 bfs메소드 돌릴때마다 list를 생성하면 되네?

//12:30 ~ 1:15까지 마지막30분 고민 더해보기
import java.io.*;
import java.util.*;

public class Main1623404 {
	
	static int n,L,R,sum,cnt;
	static StringTokenizer st;
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<Node> list;
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	static class Node{
		int x, y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public String toString() {
			return "x = " + x + ", y = " + y;
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
			boolean isMove = false;
			visited = new boolean[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(!visited[i][j]) {
						bfs(i,j);
						if(list.size()> 1) {
							isMove = true;
							result();
						} 
						sum = 0;
					}
				}
			}
			
			if(!isMove) {
				break;
			}
			cnt+=1;
		}
		System.out.println(cnt);
	}
	
	static void bfs(int x, int y) {
		list = new ArrayList<Node>();
		visited[x][y] = true;
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(x,y));
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
				
				int val = Math.abs(map[node.x][node.y] - map[nx][ny]);
				if(val >= L && val <= R) {
					list.add(new Node(nx, ny));
					visited[nx][ny] = true;
					sum += map[nx][ny];
					q.offer(new Node(nx, ny));
				}
			}
		}
	}
	
	static void result() {
		//System.out.println(list);
		//System.out.println(sum);
		//System.out.println(list.size());
		int avg = sum / list.size();
		for(int i=0; i<list.size(); i++) {
			Node node = list.get(i);
			map[node.x][node.y] = avg;
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("===========");
	}

}
