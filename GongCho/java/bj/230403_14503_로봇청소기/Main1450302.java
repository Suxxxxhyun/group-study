package baekjun.simulation;

//3:49 ~ 4:20
import java.io.*;
import java.util.*;
//visited배열은 왜 필요했는가에 정당성 부여해보기
public class Main1450302 {
	
	static int n,m,r,c,d;
	static StringTokenizer st;
	static int[][] map;
	//dir의 인덱스가 북동남서의 인덱스를 가리킨다!
	static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
	static boolean[][] visited;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		visited[r][c] = true;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		pro();
	}
	
	static void turn_left() {
		d -= 1;
		if(d == -1) {
			d = 3;
		}
	}
	
	static void pro() {
		int cnt = 1;
		int turn_time = 0;
		
		while(true) {
			turn_left();
			int nx = r + dir[d][0];
			int ny = c + dir[d][1];
			if(map[nx][ny] == 0 && !visited[nx][ny]) {
				cnt += 1;
				turn_time = 0;
				r = nx;
				c = ny;
				visited[nx][ny] = true;
				continue;
			} else {
				turn_time++;
			}
			
			if(turn_time == 4) {
				//후진을 해줘야하므로 빼기를 해줌.
				nx = r - dir[d][0]; // 1 - (-1) = 2
				ny = c - dir[d][1]; // 1 - 0 = 1
				if(map[nx][ny] == 0) {
					r = nx;
					c = ny;
					turn_time = 0;
				} else break;
			}
		}
		System.out.println(cnt);
	}

}
