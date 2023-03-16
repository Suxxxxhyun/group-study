package baekjun.src.baekjun.CumulativeSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11659 {

    static int n,m;
    static int[] a, sum;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n+1];
        sum = new int[n+1];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=n; i++){
            sum[i] = sum[i-1] + a[i];
        }
        /*for(int i=0; i<=n; i++){
            System.out.print(sum[i] + " ");
        }
        System.out.println();*/
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int I = Integer.parseInt(st.nextToken());
            int J = Integer.parseInt(st.nextToken());
            if(I == J){
                sb.append(a[I]).append('\n');
            } else {
                sb.append(sum[J] - sum[I-1]).append('\n');
            }
        }
        System.out.println(sb);
    }
}
