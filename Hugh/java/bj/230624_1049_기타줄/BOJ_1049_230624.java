package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1049_230624 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int pack = Integer.parseInt(st.nextToken());
            int single = Integer.parseInt(st.nextToken());

            list1.add(pack);
            list2.add(single);
        }
        Collections.sort(list1);
        Collections.sort(list2);

        int min = Integer.MAX_VALUE;

        // 가장 싼 6개짜리 팩 vs 가장 싼 낱개 vs (가장 싼 6개짜리 팩 + 가장 싼 낱개)
        min = Math.min(((N/6)+1) * list1.get(0), N * list2.get(0));
        min = Math.min(min, (N/6) * list1.get(0) + (N%6) * list2.get(0));

        sb.append(min);
        System.out.println(sb);
    }
}
