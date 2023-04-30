package baekjun.simulation;

//7:12 ~ 7:42
import java.io.*;
import java.util.*;

public class Main1568305 {
	
	static int[][] map;
	static int n,m,remain, cnt, res = Integer.MAX_VALUE;
	static StringTokenizer st;
	static CCTV[] cctvs;
	//╩С,го,аб,©Л
	static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
	static int[][][] cctv = {
			{{0}},
			{{0},{1},{2},{3}},
			{{0,2},{1,3}},
			{{0,1},{1,2},{2,3},{0,3}},
			{{0,1,3},{0,1,2},{1,2,3},{0,2,3}},
			{{0,1,2,3}}
	};
	
	static class CCTV{
		int type, x, y;
		
		public CCTV(int type, int x, int y) {
			this.type = type;
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
		remain = n * m;
		cctvs = new CCTV[8];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 6) {
					remain--;
				} else if(map[i][j] >= 1 && map[i][j] <= 5) {
					cctvs[cnt++] = new CCTV(map[i][j], i, j);
				}
			}
		}
		
		remain -= cnt;
		pro(0,remain,map);
		System.out.println(res);

	}
	
	static void pro(int idx, int remain, int[][] map) {
		if(idx == cnt) {
			res = Math.min(remain, res);
			return;
		}
		
		int[][] newMap = new int[n][m];
		copy(newMap, map);
		
		CCTV c = cctvs[idx];
		for(int i=0; i<cctv[c.type].length; i++) {
			int count = 0;
			for(int j=0; j<cctv[c.type][i].length; j++) {
				int d = cctv[c.type][i][j];
				count += observation(d, c.x, c.y, newMap);
			}
			pro(idx + 1, remain - count, newMap);
			copy(newMap, map);
		}
	}
	
	static int observation(int d, int x, int y, int[][] map) {
		
		int observation_count = 0;
		
		while(true) {
			x += dir[d][0];
			y += dir[d][1];
			
			if(x < 0 || y < 0 || x >= n || y >= m || map[x][y] == 6) {
				return observation_count;
			}
			
			if((map[x][y] == -1) || (map[x][y] >= 1 && map[x][y] <= 5)) {
				continue;
			}
			
			map[x][y] = -1;
			observation_count+=1;
		}
	}
	
	static void copy(int[][] newMap, int[][] map) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				newMap[i][j] = map[i][j];
			}
		}
	}

}
