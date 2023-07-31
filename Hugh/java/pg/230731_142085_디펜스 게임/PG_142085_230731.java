package Programmers.Lv2;
import java.util.*;
public class PG_142085_230731 {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;

        if (enemy.length == k) return k;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < enemy.length; i++) {
            pq.offer(enemy[i]);
            if (pq.size() > k) n -= pq.poll(); // 크기가 큰 적군 k만큼은 최대한 뒤로 이동
            if (n < 0) return i;
        }

        return enemy.length;
    }
}
