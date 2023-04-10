package baekjun.src.baekjun.BinarySearch;

import java.io.*;
import java.util.*;

public class Main182202 {

    static int an, bn;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static Set<Integer> a = new TreeSet<Integer>();
    //static Set<Integer> a = new HashSet<Integer>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        an = Integer.parseInt(st.nextToken());
        bn = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<an; i++){
            a.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<bn; i++){
            int b = Integer.parseInt(st.nextToken());
            a.remove(b);
        }

        sb.append(a.size()).append('\n');

        Iterator<Integer> iter = a.iterator();
        while(iter.hasNext()){
            sb.append(iter.next() + " ");
        }
        System.out.println(sb);
    }
}
