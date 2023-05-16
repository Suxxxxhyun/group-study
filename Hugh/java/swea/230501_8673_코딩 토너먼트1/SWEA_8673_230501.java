package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_8673_230501 {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            Queue<Integer> q = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < (int)Math.pow(2,N); j++) {
                q.offer(Integer.parseInt(st.nextToken()));
            }
            int cnt = 0;
            while (q.size() != 1) {
                int a = q.poll();
                int b = q.poll();

                int max = Math.max(a, b);
                int min = Math.min(a, b);
                cnt += (max - min);

                q.offer(max);
            }
            sb.append(String.format("#%d %d\n", i, cnt));
        }
        System.out.println(sb);
    }
}
