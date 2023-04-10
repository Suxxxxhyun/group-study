package baekjun.src.baekjun.BinarySearch;

import java.io.*;
import java.util.*;
//10:18 ~ 10:40
//이것까지만 하고 투포인터,이분탐색,문자열 랜덤으로 돌릴것
public class Main1822 {

    static int an, bn;
    static long[] a,b;
    static ArrayList<Long> answer = new ArrayList<Long>();
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        an = Integer.parseInt(st.nextToken());
        bn = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        a = new long[an];
        for(int i=0; i<an; i++){
            a[i] = Long.parseLong(st.nextToken());
        }
        b = new long[bn];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<bn; i++){
            b[i] = Long.parseLong(st.nextToken());
        }
        //50만log50만
        Arrays.sort(b);
        for(int i=0; i<an; i++){
            long val = pro(a[i]);
            if(val == 0){
                continue;
            } else {
                answer.add(val);
            }
        }
        if(answer.size() == 0){
            sb.append(0);
        } else {
            Collections.sort(answer);
            sb.append(answer.size()).append('\n');
            for(int i=0; i<answer.size(); i++){
                sb.append(answer.get(i)).append(" ");
            }
        }
        System.out.println(sb);
    }

    static long pro(long num){
        int L=0, R=bn-1, ans = -1;
        while(L <= R){
            int mid = (L + R) / 2;

            if(b[mid] > num){
                R = mid - 1;
            } else if(b[mid] < num){
                L = mid + 1;
            } else {
                ans = mid;
                break;
            }
        }
        if(ans == -1){
            return num;
        } else {
            //a의 원소가 b에도 있다.
            return 0;
        }
    }
}
