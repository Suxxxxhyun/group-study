package baekjun.BackTrack;

import java.io.*;
import java.util.*;

//2:47 ~ 3:20
public class Main1488906 {
	
	static int n, res = Integer.MAX_VALUE;
	static int[][] map, selected_start, selected_link;
	static StringTokenizer st;
	
	//그럼 난 이전에 02번에서 start로 접근했던데, 그 이유 파악하고 넘어가기 ->시간복잡도를 줄일 수 있음.
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<=n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		selected_start = new int[n/2 + 1][n/2 + 1];
		selected_link = new int[n/2 + 1][n/2 + 1];
		pro(1);
		System.out.println(res);
	}
	
	static void pro(int idx) {
		
		if(idx == n / 2 + 1) {
			int link_index = 1;
			for(int i=1, j=1; i<=n; i++) {
				if(j <= n/2) {
					if(selected_start[0][j] == i) {
						j++;
						continue;
					}
				}
				selected_link[0][link_index] = i;
				selected_link[link_index][0] = i;
				link_index++;
			}
			calculator();
			return;
		}
		
		
		int start = 1;
		if(idx != 1) {
			start = selected_start[0][idx-1] + 1;
		}
		
		for(int i=start; i<=n; i++) {
			selected_start[0][idx] = i;
			selected_start[idx][0] = i;
			pro(idx + 1);
		}
	}
	
	static void calculator() {
		
		int start_sum = 0, link_sum = 0;
		
		for(int i=1; i<=n/2; i++) {
			for(int j=1; j<=n/2; j++) {
				if(i == j) {
					continue;
				}
				start_sum += map[selected_start[i][0]][selected_start[0][j]];
				link_sum += map[selected_link[i][0]][selected_link[0][j]];
			}
		}
		
		res = Math.min(Math.abs(start_sum - link_sum), res);
	}

}
