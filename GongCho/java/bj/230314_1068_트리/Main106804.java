package baekjun.Tree;

import java.io.*;
import java.util.*;

public class Main106804 {
	
	static int n, root, erased;
	static StringTokenizer st;
	static ArrayList<Integer>[] child;
	static int[] leaf; //lef[x] : x를 root로 하는 단말노드의 개수

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		child = new ArrayList[n];
		st = new StringTokenizer(br.readLine(), " ");
		leaf = new int[n];
		
		for(int i=0; i<n; i++) {
			child[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<n; i++) {
			int x = Integer.parseInt(st.nextToken());
			if(x == -1) {
				root = i;
				continue;
			}
			child[x].add(i);
		}
		
		erased = Integer.parseInt(br.readLine());
		pro();

	}
	
	static void pro() {
		for(int i=0; i<n; i++) {
			if(child[i].contains(erased)) {
				child[i].remove(child[i].indexOf(erased));
			}
		}
		
		if(erased != root) {
			dfs(root, -1);
		}
		
		System.out.println(leaf[root]);
	}
	
	static void dfs(int x, int par) {
		if(child[x].isEmpty()) {
			leaf[x]++;
		}
		
		for(int y : child[x]) {
			dfs(y, x);
			leaf[x] += leaf[y];
		}
	}

}
