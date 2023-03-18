package baekjun.sort;

import java.io.*;
import java.util.*;

public class Main11650 {
	
	static int n;
	static StringTokenizer st;
	static Node[] arr;
	static StringBuilder sb = new StringBuilder();
	
	static class Node implements Comparable<Node>{
		int x, y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public int compareTo(Node other) {
			if(this.x == other.x) {
				return this.y - other.y;
			}
			return this.x - other.x;
		}
	}

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new Node[n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[i] = new Node(x,y);
		}
		
		Arrays.sort(arr);
		for(int i=0; i<arr.length; i++) {
			sb.append(arr[i].x + " " + arr[i].y).append('\n');
		}
		System.out.println(sb);
	}

}
