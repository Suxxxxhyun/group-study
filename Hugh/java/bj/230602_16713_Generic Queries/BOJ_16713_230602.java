package BOJ.DP;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_16713_230602 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i + 1] = arr[i] ^ Integer.parseInt(st.nextToken());
        }

        int result = 0;
        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            result = result ^ (arr[e] ^ arr[s - 1]);
        }


        bw.write(String.valueOf(result));
        bw.flush();

        bw.close();
        br.close();
    }
}
