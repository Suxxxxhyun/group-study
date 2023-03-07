package baekjun.src.baekjun.BFSDFS;

import java.io.*;
import java.util.*;
public class Main13549 {

    static int n,k,time = Integer.MAX_VALUE;
    static int[] visited = new int[100001];
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        if(n == k){
            System.out.println(0);
        } else {
            bfs();
        }
    }

    static void bfs(){
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(n);
        visited[n] = 0;
        while(!q.isEmpty()){
            int x = q.poll();

            int nx;
            for(int i=0; i<3; i++){
                if(i == 0){
                   nx = x * 2;
                } else if(i == 1){
                    nx = x - 1;
                } else {
                    nx = x + 1;
                }

                if((nx >= 0 && nx <= 100000) && visited[nx] == 0){
                    if(i == 0){
                        visited[nx] = visited[x];
                        if(nx == k){
                            System.out.println(visited[nx]);
                            return;
                        }
                        q.offer(nx);
                    } else {
                        visited[nx] = visited[x] + 1;
                        if(nx == k){
                            System.out.println(visited[nx]);
                            return;
                        }
                        q.offer(nx);
                    }
                }
            }
        }
    }
}
