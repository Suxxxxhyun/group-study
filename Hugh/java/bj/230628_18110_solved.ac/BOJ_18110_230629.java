package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_18110_230629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);
        Deque<Integer> deq = new ArrayDeque<>(list);

        int temp = (int) Math.round(N * 0.15);
        while (temp-- > 0) {
            deq.removeFirst();
            deq.removeLast();
        }

        int sum = 0;
        double deqSize = deq.size();
        while (!deq.isEmpty()) {
            sum += deq.poll();
        }

        sb.append(Math.round(sum / deqSize));
        System.out.println(sb);
    }
}
