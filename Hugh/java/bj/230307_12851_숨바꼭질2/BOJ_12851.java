package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_12851 {
    static int n, k;
    static int min = Integer.MAX_VALUE;
    static int cnt = 0;
    static int visited[] = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());


        if (n >= k)
        {
            System.out.println(n-k);
            System.out.println(1);
            return;
        }

        bfs(n);

        System.out.println(min);
        System.out.println(cnt);

    }

    static void bfs(int node){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(node);
        visited[node] = 1;

        while(!q.isEmpty()){
            int now = q.remove();

            if(min < visited[now])
                continue;

            for (int i = 0; i < 3; i++){
                int next;

                if(i == 0)
                    next = now * 2;
                else if(i == 1)
                    next = now + 1;
                else
                    next = now - 1;

                if(next < 0 || next > 100000)
                    continue;

                if(next == k){
                    min = visited[now];
                    cnt++;
                }

                if(visited[next] == 0 || visited[next] == visited[now] + 1){
                    q.add(next);
                    visited[next] = visited[now] + 1;
                }
            }
        }
    }
}
