package baekjun.DFSBFS;

import java.io.*;
import java.util.*;

public class Main1842802 {
	
	static int n, b, cnt, sum;
	static StringTokenizer st;
	static char[][] map;
	static boolean[][] visited;
	static int[][] blank;
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new char[n+1][n+1];
		visited = new boolean[n+1][n+1];
		blank = new int[n*n+1][2];
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<=n; j++) {
				char x = st.nextToken().charAt(0);
				map[i][j] = x;
				if(x == 'X') {
					b++;
					blank[b][0] = i;
					blank[b][1] = j;
				} else if(x == 'T'){
					cnt += 1;
				}
			}
		}
		pro(1,0);
		if(sum != cnt) {
			System.out.println("NO");
		}
	}
	
	static void pro(int selected_idx, int selected_cnt) {
		if(selected_cnt == 3) {
			sum = 0;
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					if(map[i][j] == 'T') {
						if(dfs(i,j)) {
							break;
						}
						sum+=1;
					}
				}
			}
			/*for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println(sum);*/
			if(sum == cnt) {
				System.out.println("YES");
				System.exit(0);
			}
			return;
		}
		
		if(selected_idx > b) {
			return;
		}
		
		map[blank[selected_idx][0]][blank[selected_idx][1]] = 'O';
		pro(selected_idx + 1, selected_cnt + 1);
		map[blank[selected_idx][0]][blank[selected_idx][1]] = 'X';
		pro(selected_idx + 1, selected_cnt);
	}
	
	//선생님이 학생을 발견했다면, true. // 장애물을 만났다면 false
	static boolean dfs(int x, int y) {
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];
			
			while(confirm(nx,ny)) {
				if(map[nx][ny] == 'O') {
					break;
				}
				if(map[nx][ny] == 'S') {
					return true;
				}
				nx = nx + dir[i][0];
				ny = ny + dir[i][1];
			}
		}
		return false;
	}
	
	static boolean confirm(int x, int y) {
		if(x <= 0 || y <= 0 || x > n || y > n) {
			return false;
		}
		return true;
	}

}
