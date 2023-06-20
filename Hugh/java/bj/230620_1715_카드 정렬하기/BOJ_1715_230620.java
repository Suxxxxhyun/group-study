package BOJ.Greedy;

import java.io.*;
import java.util.PriorityQueue;

public class BOJ_1715_230620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int result = 0;
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();

            result += (a + b);
            pq.add(a + b);
        }

        bw.write(String.valueOf(result));
        bw.flush();

        bw.close();
        br.close();
    }
}
