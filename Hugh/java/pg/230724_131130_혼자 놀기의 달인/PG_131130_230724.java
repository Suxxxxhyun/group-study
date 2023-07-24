package Programmers.Lv2;

import java.util.*;

/*
    10:13~
    최고점수 구하기
    DFS

    1 4 7 8
    2 5 6
    3

    visit으로 방문처리
*/

public class PG_131130_230724 {
    static boolean[] visited;
    static int cnt;
    public int solution(int[] cards) {
        int answer = 0;
        visited = new boolean[cards.length + 1];
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < cards.length; i++) {

            cnt = 0;
            dfs(cards[i], cards);
            list.add(cnt);
        }

        Collections.sort(list, Collections.reverseOrder());
        return list.get(0) * list.get(1);
    }

    static void dfs(int idx, int[] cards) {
        if (visited[idx]) {
            return;
        }

        visited[idx] = true;
        cnt++;
        dfs(cards[idx-1], cards);

    }
}
