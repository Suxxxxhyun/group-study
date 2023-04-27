package baekjun.simulation;

//7:50 ~ 8:20
import java.io.*;
import java.util.*;

public class Main15686 {
	
	static int n,m, ans = Integer.MAX_VALUE;
	static StringTokenizer st;
	static int[][] map;
	static ArrayList<Node> chickens = new ArrayList<Node>();
	static ArrayList<Node> houses = new ArrayList<Node>();
	//고른 치킨집을 담는 배열
	static int[] choose;
	
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
		map = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					chickens.add(new Node(i,j));
				} else if(map[i][j] == 1) {
					houses.add(new Node(i,j));
				}
			}
		}
		//치킨집자체를 고를때, 중복을 허용하지 않으면서, 순서를 고려하지 않는 조합에 해당함.
		choose = new int[m];
		pro(0);
		System.out.println(ans);
	}
	
	static void pro(int idx) {
		
		if(idx == m) {
			//거리구하는 메소드
			ans = Math.min(ans,solution());
			return;
		}
		
		int start = 0;
		if(idx != 0) {
			start = choose[idx - 1] + 1;
		}
		
		for(int cand=start; cand<chickens.size(); cand++) {
			choose[idx] = cand;
			pro(idx + 1);
		}
	}
	
	static int solution() {
		int sum = 0;
		for(int i=0; i<houses.size(); i++) {
			int hx = houses.get(i).x;
			int hy = houses.get(i).y;
			int dist = Integer.MAX_VALUE;
			for(int j=0; j<choose.length; j++) {
				int distance = Math.abs(chickens.get(choose[j]).x - hx) + Math.abs(chickens.get(choose[j]).y - hy);
				dist = Math.min(dist, distance);
			}
			sum += dist;
		}
		return sum;
	}

}
