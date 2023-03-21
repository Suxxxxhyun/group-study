package BOJ.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_2164_230321 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 1; i <= n; i++) {
            deque.add(i);
        }

        int temp = 0;
        while(deque.size() > 1) {
            deque.pollFirst();
            temp = deque.pollFirst();
            deque.addLast(temp);
        }
        System.out.println(deque.poll());
    }
}
