package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_10811_230308 {
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int tmp = 0;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = i + 1;
        }

        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            int begin = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if (begin == end)
                continue;

            while (begin < end){
                tmp = arr[begin - 1];
                arr[begin - 1] = arr[end - 1];
                arr[end - 1] = tmp;

                begin++;
                end--;
            }
        }

        for (int x: arr){
            sb.append(x).append(" ");
        }

        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}
