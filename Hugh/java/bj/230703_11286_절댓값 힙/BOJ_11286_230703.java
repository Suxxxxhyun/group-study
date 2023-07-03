package BOJ.Queue;

import java.io.*;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


// 09:20~09:50
public class BOJ_11286_230703 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) > Math.abs(o2)) {
                    return Math.abs(o1) - Math.abs(o2);
                } else if (Math.abs(o1) == Math.abs(o2)) {
                    return o1 - o2;
                } else {
                    return -1;
                }
            }
        });

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(br.readLine());
            if (val != 0) {
                pq.offer(val);
            } else {
                if (!pq.isEmpty()) {
                    sb.append(pq.poll()).append("\n");
                }
                else sb.append(0).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }
}
