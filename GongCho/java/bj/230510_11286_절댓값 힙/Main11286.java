package baekjun.src.baekjun.implement;

import java.io.*;
import java.util.*;
//12:48 ~ 1:20
public class Main11286 {

    static int n;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1,o2) -> {
           int abs1 = Math.abs(o1);
           int abs2 = Math.abs(o2);
           if(abs1 == abs2) {
               return o1 - o2;
           }
           return abs1 - abs2;
        });
        for(int i=0; i<n; i++){
            int x = Integer.parseInt(br.readLine());
            if(x == 0){
                if(!pq.isEmpty()){
                    sb.append(pq.poll()).append('\n');
                } else {
                    sb.append(0).append('\n');
                }
            } else {
                pq.offer(x);
            }
        }
        System.out.println(sb);
    }
}
