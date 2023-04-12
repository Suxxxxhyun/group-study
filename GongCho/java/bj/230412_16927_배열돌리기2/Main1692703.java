package baekjun.simulation;

//12:54 ~ 1:10
import java.io.*;
import java.util.*;

public class Main1692703 {
	
	static StringTokenizer st;
	static int n,m,r;
	static int[][] map;
	static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		pro();
	}
	
	static void pro() {
		int line = Math.min(n,m) / 2;
		int row = n, col = m;
		for(int i=0; i<line; i++) {
			rotate(i, row * 2 + col * 2 - 4);
			row -= 2;
			col -= 2;
		}
		
		print();
	}
	
	static void rotate(int start, int cnt) {
		int count = r % cnt;
		for(int i=0; i<count; i++) {
			int x = start;
			int y = start;
			int value = map[x][y];
			
			int idx = 0;
			while(idx < 4) {
				int nx = x + dir[idx][0];
				int ny = y + dir[idx][1];
				
				if(nx >= start && ny >= start && nx < n - start && ny < m - start) {
					map[x][y] = map[nx][ny];
					x = nx;
					y = ny;
				} else {
					idx++;
				}
			}
			map[start + 1][start] = value;
		}
	}
	
	static void print() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
