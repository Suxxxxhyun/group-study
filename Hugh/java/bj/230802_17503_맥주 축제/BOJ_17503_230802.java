package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    09:15~09:39
    선호도의 합 M을 채우면서 N개의 맥주를 마실 수있는 간 레벨의 최솟값
 */

class BEER {
    int prefer;
    int alcohol;

    public BEER(int prefer, int alcohol) {
        this.prefer = prefer;
        this.alcohol = alcohol;
    }
}
public class BOJ_17503_230802 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //축제가 열리는 기간
        int m = Integer.parseInt(st.nextToken()); //채워야 하는 선호도의 합
        int k = Integer.parseInt(st.nextToken()); //마실 수 있는 맥주 종류의 수

        ArrayList<BEER> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken()); //맥주의 선호도
            int c = Integer.parseInt(st.nextToken()); //도수 레벨

            list.add(new BEER(v,c));
        }

        Collections.sort(list, ((o1, o2) -> {
            if (o1.alcohol == o2.alcohol) {
                return o2.prefer - o1.prefer; //도수 같다면 선호도 기준 내림차순 정렬
            }
            return o1.alcohol - o2.alcohol; //도수 기준 오름차순 정렬
        }));

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 들어오는 선호도 오름차순 정렬
        int sum = 0;
        int result = -1;
        for (BEER beer : list) {
            pq.offer(beer.prefer);
            sum += beer.prefer;

            if (pq.size() > n) sum -= pq.poll();
            if (pq.size() == n && sum >= m) {
                result = beer.alcohol;
                break;
            }
        }

        System.out.println(result); //실패 했을 경우
    }
}
