package baekjun.src.baekjun.Tree;

//~1:20
import java.io.*;
import java.util.*;
public class Main3584 {

    static int t, n, a, b, A, B;
    static ArrayList<Integer>[] graph;
    static StringTokenizer st;
    static boolean[] visited;
    static ArrayList<Integer> parentA;
    static ArrayList<Integer> parentB;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            n = Integer.parseInt(br.readLine());
            graph = new ArrayList[n+1];
            parentA = new ArrayList<Integer>();
            parentB = new ArrayList<Integer>();
            for(int v=1; v<=n; v++){
                graph[v] = new ArrayList<Integer>();
            }
            visited = new boolean[n+1];
            for(int j=0; j<n-1; j++){
                st = new StringTokenizer(br.readLine(), " ");
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                //graph[a].add(b);
                graph[b].add(a);
            }
            st = new StringTokenizer(br.readLine(), " ");
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            dfs(A, parentA);
            visited = new boolean[n+1];
            dfs(B, parentB);
            for(int l=0; l<parentB.size(); l++){
                if(parentA.contains(parentB.get(l))){
                    sb.append(parentB.get(l)).append('\n');
                    break;
                }
            }
            /*for(int x : parentA){
                System.out.print(x + " ");
            }
            System.out.println();
            for(int y : parentB){
                System.out.print(y + " ");
            }*/
        }
        System.out.println(sb);
    }

    static void dfs(int start, ArrayList<Integer> a){
        visited[start] = true;
        a.add(start);

        for(int i=0; i<graph[start].size(); i++){
            if(!visited[graph[start].get(i)]){
                dfs(graph[start].get(i), a);
            }
        }
    }
}
