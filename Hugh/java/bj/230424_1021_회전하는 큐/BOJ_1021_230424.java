package BOJ.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1021_230424 {
    static int N, M;
    static ArrayList<Integer> list = new ArrayList<>();
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        while (M-- > 0) {
            q.offer(Integer.parseInt(st.nextToken()));
        }

        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        int cnt = 0;
        while (!q.isEmpty()) {
            int removeNum = q.poll();
            int mid = (list.size() - 1) / 2;

            if (mid < list.indexOf(removeNum)) {
                while (true) {
                    if (list.get(0) == removeNum) {
                        list.remove(0);
                        break;
                    }

                    list.add(0, list.get(list.size() - 1));
                    list.remove(list.size() - 1);
                    cnt++;
                }

            } else {
                while (true) {
                    if (list.get(0) == removeNum) {
                        list.remove(0);
                        break;
                    }

                    list.add(list.get(0));
                    list.remove(0);
                    cnt++;
                }
            }

        }

        System.out.println(cnt);
    }
}
