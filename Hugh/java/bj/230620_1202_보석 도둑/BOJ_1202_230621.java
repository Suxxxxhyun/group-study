package BOJ.Greedy;

import java.io.*;
import java.util.*;

class Jewel implements Comparator<Jewel> {
    int weight; // 무게
    int value; // 가격

    Jewel(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    @Override
    public int compare(Jewel o1, Jewel o2) {
        if (o1.weight == o2.weight) {
            return o2.value - o1.value;
        } else {
            return o1.weight - o2.weight;
        }
    }
}
public class BOJ_1202_230621 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<Jewel> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.add(new Jewel(w, v));
        }

        int[] bags = new int[k];
        for (int i = 0; i < k; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long ans = 0;
        for (int i = 0, j = 0; i < k; i++) {
            while (j < n && list.get(j).weight <= bags[i]) {
                pq.offer(list.get(j).value);
            }

            if (!pq.isEmpty()) {
                ans += pq.poll();
            }
        }

        bw.write(ans + "\n");
        bw.flush();

        bw.close();
        br.close();
    }
}
