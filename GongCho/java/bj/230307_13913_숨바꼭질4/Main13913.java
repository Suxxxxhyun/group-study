package baekjun.src.baekjun.BFSDFS;

import java.io.*;
import java.util.*;
public class Main13913 {

    static int n,k;
    static StringTokenizer st;
    static int[] visited = new int[100001];
    static int[] location = new int[100001];
    //입력이 [5 17]이었다면, 5에서는 4,6,10으로 갈 수 있는데, 4,6,10은 5에서 출발해서 도착한 케이스임.
    //즉, 현재 위치로 이동했던 출발지는 1개이다. 따라서, location배열에 직전위치를 담아줄 것임.
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        if(n == k){
            sb.append(0).append('\n');
            sb.append(n);
            System.out.println(sb);
        } else {
            bfs();

            Stack<Integer> stack = new Stack<>();
            stack.push(k);
            int idx = k;

            while(idx != n){
                stack.push(location[idx]);
                idx = location[idx];
            }

            while(!stack.isEmpty()){
                sb.append(stack.pop()).append(' ');
            }
            System.out.println(sb);
        }
    }

    static void bfs(){
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(n);
        visited[n] = 1;
        while(!q.isEmpty()){
            int x = q.poll();

            if(x == k){
                sb.append(visited[x] - 1).append('\n');
                return;
            }

            int nx;
            for(int i=0; i<3; i++){
                if(i == 0){
                    nx = x - 1;
                } else if(i == 1){
                    nx = x + 1;
                } else {
                    nx = x * 2;
                }

                if((nx >= 0 && nx <= 100000) && visited[nx] == 0){
                    visited[nx] = visited[x] + 1;
                    location[nx] = x;
                    q.offer(nx);
                }
            }
        }
    }
}
