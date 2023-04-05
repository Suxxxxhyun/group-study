package baekjun.simulation;

import java.io.*;
import java.util.*;
//4:00 ~ 4:50
public class Main1568303 {
	
	//cnt = cctv의 개수, remain - 사각지대의 영역의 개수
	static int n,m,cnt, remain, res = Integer.MAX_VALUE;
	static StringTokenizer st;
	static int[][] map;
	static CCTV[] cctvs;
	static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
	static int[][][] ctvDir = {
			{{0}},
			{{0},{1},{2},{3}},
			{{3,1},{0,2}},
			{{0,1},{1,2},{2,3},{3,0}},
			{{0,3,1},{1,2,3},{0,1,2},{2,3,0}},
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
		cctvs = new CCTV[8];
		remain = n * m;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] >= 1 && map[i][j] <= 5) {
					cctvs[cnt++] = new CCTV(map[i][j], i,j);
				} else if(map[i][j] == 6){
					remain--;
				}
			}
		}
		
		pro(0, remain - cnt, map);
		System.out.println(res);
	}
	
	static void pro(int idx, int remain, int[][] map) {
		if(idx == cnt) {
			res = Math.min(res, remain);
			/*System.out.println("현재 cctv를 모두 확인한 후의 map");
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}*/
			return;
		}
		
		CCTV cc = cctvs[idx];
		int[][] newgraph = new int[n][m];
		copy(newgraph, map);
		
		/*System.out.println("map1값---------------------");
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("--------------------");*/
		
		for(int i=0; i<ctvDir[cc.type].length; i++) {
			int check = 0;
			for(int j=0; j<ctvDir[cc.type][i].length; j++) {
				int d = ctvDir[cc.type][i][j];
				
				check += observation(cc.x, cc.y, d, newgraph);
			}
			
			pro(idx + 1, remain - check, newgraph);
			/*System.out.println("map2값---------------------");
			for(int l=0; l<n; l++) {
				for(int w=0; w<m; w++) {
					System.out.print(map[l][w] + " ");
				}
				System.out.println();
			}
			System.out.println("--------------------");*/
			copy(newgraph, map);
			/*System.out.println("newmap값---------------------");
			for(int l=0; l<n; l++) {
				for(int w=0; w<m; w++) {
					System.out.print(newgraph[l][w] + " ");
				}
				System.out.println();
			}
			System.out.println("--------------------");*/
		}
	}
	
	static int observation(int x, int y, int d,int[][] map) {
		int cnt = 0;
		
		while(true) {
			x += dir[d][0];
			y += dir[d][1];
			
			if(x < 0 || x >= n || y < 0 || y >= m || map[x][y] == 6) {
				return cnt;
			}
			
			if((map[x][y] >= 1 && map[x][y] <= 5) || map[x][y] == -1) {
				continue;
			}
			
			map[x][y] = -1;
			cnt += 1;
		}
	}
	
	static void copy(int[][] newgraph, int[][] map) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				newgraph[i][j] = map[i][j];
			}
		}
	}

}
