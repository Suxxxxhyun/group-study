package BOJ.DP;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_19951_230605 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        int[] accumK = new int[N + 2];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            accumK[a] += k;
            accumK[b + 1] -= k;
        }

        int accum = 0;
        for (int i = 1; i < arr.length; i++) {
            accum += accumK[i];
            arr[i] += accum;
            sb.append(arr[i] + " ");
        }

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }
}
