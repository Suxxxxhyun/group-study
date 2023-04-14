package baekjun.src.baekjun.implement;

//3:18 ~ 3:50
import java.io.*;
import java.util.*;
public class Main2798 {

    static int n,m,gap = Integer.MAX_VALUE, ans = 0;
    static StringTokenizer st;
    static int[] a, selected;
    static boolean[] isUsed;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n];
        isUsed = new boolean[n];
        selected = new int[3];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        pro(0);
        System.out.println(ans);
    }

    static void pro(int idx){
        if(idx == 3){
            int sum = 0;
            for(int i=0; i<3; i++){
                sum += selected[i];
            }
            if(sum > m){
                return;
            } else {
                if(gap > m - sum){
                    gap = m - sum;
                    ans = sum;
                }
                return;
            }
        }
        for(int i=0; i<n; i++){
            if(!isUsed[i]){
                selected[idx] = a[i];
                isUsed[i] = true;
                pro(idx + 1);
                isUsed[i] = false;
            }
        }
    }
}
