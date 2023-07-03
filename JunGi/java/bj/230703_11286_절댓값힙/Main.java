import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/** 2023.07.03 (09:17 ~ 09:30)
 *
 * */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CustomPriorityQueue pq = new CustomPriorityQueue();

        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for(int tc=0; tc<T; tc++) {
            int num = sc.nextInt();

            if(num == 0) {
                int removed = pq.remove();
                sb.append(removed).append("\n");
            } else {
                pq.add(num);
            }
        }
        System.out.println(sb.toString());
    }
}

class CustomPriorityQueue {
    private PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            if(Math.abs(o1) == Math.abs(o2)) {
                return o1 - o2;
            }
            return Math.abs(o1) - Math.abs(o2);
        }
    });

    public int remove() {
        if(pq.isEmpty()) {
            return 0;
        }
        return pq.poll();
    }

    public void add(int num) {
        pq.add(num);
    }
}
