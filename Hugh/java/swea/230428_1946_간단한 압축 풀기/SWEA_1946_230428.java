package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1946_230428 {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int n = Integer.parseInt(br.readLine());
            Queue<String> q = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String alpha = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                while (num-- > 0) {
                    q.offer(alpha);
                }
            }
            sb.append(String.format("#%d\n", i));
            int len = q.size();
            while (!q.isEmpty()) {
                for (int j = 1; j <= len; j++) {
                    sb.append(q.poll());
                    if (j % 10 == 0) {
                        sb.append("\n");
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
