package baekjun.Tree;

import java.util.*;
import java.io.*;

public class Main1172502 {

	static int n;
    static ArrayList<Integer>[] adj;
    static int[] parent;
    //static boolean[] visited;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        adj = new ArrayList[n+1];
        parent = new int[n+1];
        for(int i=1; i<=n; i++){
            adj[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        pro();
    }
    
    static void pro() {
    	dfs(1, -1);
    	
    	for(int i=2; i<=n; i++) {
    		sb.append(parent[i]).append('\n');
    	}
    	System.out.println(sb);
    }
    
    static void dfs(int x, int par) {
    	for(int y : adj[x]) {
    		if(par == y) {
    			continue;
    		}
    		parent[y] = x;
    		dfs(y,x);
    	}
    }

}
