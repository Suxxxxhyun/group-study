package BOJ.Greedy;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_4796_230624 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int cnt = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            if (L == 0 && P == 0 && V == 0) {
                break;
            }

            sb.append(String.format("Case %d: %d", cnt, (L * (V / P)) + Math.min(L, (V % P)))).append("\n");
            cnt++;
        }

        System.out.println(sb);
    }
}
