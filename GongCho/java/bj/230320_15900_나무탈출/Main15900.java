package baekjun.src.baekjun.Tree;

import java.io.*;
import java.util.*;

//블로그를 참조해보니, 단순히 리프노드에서 루트노드까지의 깊이 합이 홀수면 성원 승, 짝수면 성원 패배

public class Main15900 {

    //sum_leaf_depth : 모든 리프노드들의 깊이의 합
    static int n, depth, sum_leaf_depth;
    static StringTokenizer st;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        pro();
    }

    static void pro(){
        dfs(1,-1,0);
        if(sum_leaf_depth % 2 == 0){
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }

    static void dfs(int x, int prev, int depth){
        if(x != 1 && graph[x].size() == 1){
            sum_leaf_depth += depth;
        }

        for(int y : graph[x]){
            if(y == prev){
                continue;
            }
            dfs(y, x, depth + 1);
        }

    }


}
