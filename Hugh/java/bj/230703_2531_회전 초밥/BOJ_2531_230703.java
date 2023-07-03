package BOJ.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_2531_230703 {
    static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int max=0;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //접시수
        int d = Integer.parseInt(st.nextToken()); //초밥 수
        k = Integer.parseInt(st.nextToken()); //연속해서 먹는 접시수
        int c = Integer.parseInt(st.nextToken()); //쿠폰번호

        int[] sushi = new int[N+k-1];
        for(int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        for(int i = N; i < N+k-1; i++) {
            sushi[i] = sushi[i-N];
        }

        int ans = 0;
        HashMap<Integer, Integer> eat = new HashMap<>();

        // 첫 k개 초밥 저장
        for(int i = 0; i < k; i++) {
            eat.compute(sushi[i], (k, v) -> v == null ? 1 : v+1);
        }
        if (!eat.containsKey(c)) { // 쿠폰 초밥 없으면 +1
            ans = eat.size() + 1;
        } else ans = eat.size();

        /* 슬라이딩 윈도우 탐색 */
        // i = start?
        for (int i = 0; i < N - 1; i++) {
            if (eat.get(sushi[i]) == 1) { // 하나 남으면 삭제
                eat.remove(sushi[i]);
            } else { // 아니면 -1
                eat.put(sushi[i], eat.get(sushi[i]) - 1);
            }

            // 오른쪽 것 추가
            eat.compute(sushi[i+k], (k,v) -> v == null ? 1 : v+1);

            if (!eat.containsKey(c)) { // 쿠폰 초밥 없으면 +1
                ans = Math.max(ans, eat.size() + 1);
            } else {
                ans = Math.max(ans, eat.size());
            }
        }
        System.out.println(ans);
    }
}
