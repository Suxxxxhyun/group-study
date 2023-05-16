package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10813_230308 {
    static int n, m;
    static int tmp = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = i + 1;
        }

        for (int j = 0; j < m; j++){
            st = new StringTokenizer(br.readLine());
            int front = Integer.parseInt(st.nextToken());
            int back = Integer.parseInt(st.nextToken());

            tmp = arr[front-1];
            arr[front-1] = arr[back-1];
            arr[back-1] = tmp;
        }

        for(int x: arr){
            sb.append(x).append(" ");
        }

        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }
}
