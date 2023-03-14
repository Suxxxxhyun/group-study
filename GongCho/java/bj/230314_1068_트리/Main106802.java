package baekjun.Tree;

import java.io.*;
import java.util.*;

public class Main106802 {
	
	static int n,root,erased;
	static int[] leaf;
	static StringTokenizer st;
	static ArrayList<Integer>[] child;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		child = new ArrayList[n];
		leaf = new int[n];
		for(int i=0; i<n; i++) {
			child[i] = new ArrayList<Integer>();
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			int par = Integer.parseInt(st.nextToken());
			if(par == -1) {
				root = i;
				continue;
			}
			child[par].add(i);
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
		
		if(root != erased) {
			dfs(root,-1);
		}
		
		System.out.println(leaf[root]);
	}
	
	static void dfs(int root, int par) {
		if(child[root].isEmpty()) {
			leaf[root]++;
		}

		for(int y : child[root]) {
			dfs(y, root);
			leaf[root] += leaf[y];
		}
	}

}
