package baekjun.src.baekjun.BFSDFS;

//9:12 ~ 9:42
import java.io.*;
import java.util.*;
public class Main5567 {

    static int n,m,ans;
    static boolean[] visited;
    static ArrayList<Integer> friend = new ArrayList<Integer>();
    static StringTokenizer st;
    static ArrayList<Integer>[] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        map = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i=1; i<=n; i++){
            map[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a].add(b);
            map[b].add(a);
        }

        bfs(1);
    }

    static void bfs(int x){
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(x);
        visited[x] = true;
        while(!q.isEmpty()){
            int n = q.poll();
            for(int i=0; i<map[n].size(); i++){
                if(!visited[map[n].get(i)]){
                    visited[map[n].get(i)] = true;
                    q.offer(map[n].get(i));
                    if(n == 1){
                        friend.add(map[n].get(i));
                        ans += 1;
                    } else {
                        for(int j=0; j<friend.size(); j++){
                            if(friend.get(j) == n){
                                ans += 1;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
