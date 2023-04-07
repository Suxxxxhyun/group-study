package baekjun.DFSBFS;

import java.io.*;
import java.util.*;

//8:57 ~ 9:43 - 답지 보지말고 무조건 고민

//r과 c는 1부터 시작한다.
//치킨 거리는 집과 가장 가까운 치킨집 사이의 거리이다. 즉, 치킨 거리는 집을 기준으로 정해지며
//도시의 치킨 거리는 모든 집의 치킨 거리의 합
//0은 빈 칸, 1은 집, 2는 치킨집
//도시에 있는 치킨집 중에서 최대 M개를 고르고, 나머지 치킨집은 모두 폐업시켜야 한다.
//도시의 치킨 거리가 가장 작게 될지 구하는 프로그램
public class Main1568602 {
	
	static int n,m, res = Integer.MAX_VALUE;
	static StringTokenizer st;
	static int[][] map;
	static int[] selected_chick;
	static ArrayList<Node> chicken = new ArrayList<Node>();
	static ArrayList<Node> houses = new ArrayList<Node>();
	
	static class Node{
		int x, y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<=n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					chicken.add(new Node(i,j));
				} else if(map[i][j] == 1){
					houses.add(new Node(i,j));
				}
			}
		}
		//selected_chick를 m만큼 만들었어야했나? -> 고른치킨의 배열을 chicken.size만큼 만들었는데, 이렇게 하니, 시간복잡도가 
		//오래걸릴듯(예제 4를 보면 알 수 있음)
		//m이 3이라고 가정하였을떄, [0,4,?] , 0,4까지 고르고 나서 pro를 탈때 완탐이 종료가 되지 않음. -> .. 흠 확인일단 해보기. 일단 계속해보자.
		//52번은 꼭 확인하기(예제2로 확인)
		//예제2로 확인해보니, cand는 범위가 0번~4번임.
		//0,4를 고른순간, pro(idx+1, cnt+1)을 타게 되면, cand의 범위에 5가 속하지 않으므로,
		//애초에 for문을 돌지 않음.
		selected_chick = new int[m];
		pro(0,0);
		System.out.println(res);
	}
	
	static void pro(int idx, int cnt) {
		
		if(cnt == m) {
			//도시의치킨거리를 구하며 될듯.
			/*for(int i=0; i<selected_chick.length; i++) {
				System.out.print(selected_chick[i] + " ");
			}
			System.out.println();
			System.out.println("=================");*/
			int distance_sum = 0;
			for(int i=0; i<houses.size(); i++) {
				int xh = houses.get(i).x;
				int yh = houses.get(i).y;
				int distance = Integer.MAX_VALUE;
				for(int j=0; j<selected_chick.length; j++) {
					int xc = chicken.get(selected_chick[j]).x;
					int yc = chicken.get(selected_chick[j]).y;
					int d = Math.abs(xh- xc) + Math.abs(yh - yc);
					distance = Math.min(d, distance);
				}
				distance_sum += distance;
			}
			res = Math.min(distance_sum, res);
			//System.out.println(res);
			return;
		}
		
		int start = 0;
		if(idx != 0) {
			start = selected_chick[idx - 1] + 1;
		}
		
		for(int cand = start; cand < chicken.size(); cand++) {
			selected_chick[idx] = cand;
			pro(idx + 1, cnt + 1);
		}
	}

}
