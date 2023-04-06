package baekjun.DFSBFS;

//~4:57
import java.io.*;
import java.util.*;

public class Main217804 {
	
	static int n,m;
	static int[][] map;
	static StringTokenizer st;
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	//문자 0에 대한 아스키코드값은 48!

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		bfs(0,0);

	}
	
	static void bfs(int x, int y) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(x);
		q.offer(y);
		while(!q.isEmpty()) {
			
			int xx = q.poll();
			int yy = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = xx + dir[i][0];
				int ny = yy + dir[i][1];
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= m) {
					continue;
				}
				
				if(map[nx][ny] != 1) {
					continue;
				}
				
				if(map[nx][ny] == 1) {
					q.offer(nx);
					q.offer(ny);
					map[nx][ny] = map[xx][yy] + 1;
				}
			}
		}
		
		/*for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}*/
		
		System.out.println(map[n-1][m-1]);
	}

}
