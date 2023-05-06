package baekjun.DFSBFS;

//5:04 ~ 5:50
import java.io.*;
import java.util.*;

public class Main1842803 {
	
	static int n, count = 0, sum = 0;
	static char[][] map;
	static ArrayList<Node> teachers = new ArrayList<Node>();
	static int[][] blank;
	static StringTokenizer st;
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	//static boolean[][] visited;
	
	static class Node{
		int x, y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public String toString(int x, int y) {
			return "x = " + x + ", y = " + y;
		}
	}

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		blank = new int[n*n+1][2];
		map = new char[n][n];
		//visited = new boolean[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				map[i][j] = st.nextToken().charAt(0);
				if(map[i][j] == 'T') {
					teachers.add(new Node(i,j));
				} else if(map[i][j] == 'X') {
					count++;
					blank[count][0] = i;
					blank[count][1] = j;
				}
			}
		}
		
		pro(1,0);
		System.out.println("NO");
	}
	
	static void pro(int idx, int cnt) {
		if(cnt == 3) {
			/*List<Node> list = new ArrayList<Node>();
			
			for(int i=0; i<map.length; i++) {
				for(int j=0; j<map[i].length; j++) {
					if(map[i][j] == 'O') {
						//list.add(new Node(i,j));
					}
					//System.out.print(map[i][j] + " ");
				}
				//System.out.println();
			}
			
			for(int i=0; i<list.size(); i++) {
				System.out.print(list.get(i).x + "," + list.get(i).y + " ");
			}
			System.out.println();
			System.out.println("=======================");*/
			//visited = new boolean[n][n];
			if(bfs()) {
				System.out.println("YES");
				System.exit(0);
			} 
			return;
		}
		
		if(idx > count) {
			return;
		}
		
		map[blank[idx][0]][blank[idx][1]] = 'O';
		pro(idx + 1, cnt + 1);
		map[blank[idx][0]][blank[idx][1]] = 'X';
		pro(idx + 1, cnt);
	}
	
	static boolean bfs() {
		Queue<Node> q = new LinkedList<Node>();
		for(int i=0; i<teachers.size(); i++) {
			q.offer(teachers.get(i));
			//visited[teachers.get(i).x][teachers.get(i).y] = true;
		}
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			int x = n.x;
			int y = n.y;
			
			for(int i=0; i<4; i++) {
				int nx = x + dir[i][0];
				int ny = y + dir[i][1];
				
				// && !visited[nx][ny]
				while(isRange(nx,ny)) {
					
					if(map[nx][ny] == 'O') {
						break;
					}
					
					if(map[nx][ny] == 'S') {
						return false;
					}
					
					//visited[nx][ny] = true;
					
					nx += dir[i][0];
					ny += dir[i][1];
				}
			}
		}
		return true;
	}
	
	static boolean isRange(int x, int y) {
		return x >= 0 && y >= 0 && x < n && y < n;
	}

}
