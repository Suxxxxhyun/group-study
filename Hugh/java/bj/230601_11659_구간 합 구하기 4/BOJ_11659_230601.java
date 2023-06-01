package BOJ.DP;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11659_230601 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            if (i == 1) {
                sb.append(arr[j]).append("\n");
            } else {
                sb.append(arr[j] - arr[i - 1]).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }
}
