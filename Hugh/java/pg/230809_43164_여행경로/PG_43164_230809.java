package Programmers.Lv3;
import java.util.*;

/*
    09:10~10:10

    *DFS*
*/
public class PG_43164_230809 {
    static ArrayList<String> list;
    static boolean[] visited;

    public String[] solution(String[][] tickets) {
        String[] answer = {};

        list = new ArrayList<>();
        visited = new boolean[tickets.length];

        dfs("ICN", tickets, 0, "ICN");
        Collections.sort(list);

        return list.get(0).split(" ");
    }

    private static void dfs(String start, String[][] tickets, int cnt, String routeSum) {
        if (cnt == tickets.length) { // 모두 탐색 했으면 경로 입력하고 return
            list.add(routeSum);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals(start) && !visited[i]) {
                visited[i] = true;
                dfs(tickets[i][1], tickets, cnt+1, routeSum + " " + tickets[i][1]);
                visited[i] = false; // 모든 경우를 탐색하기 위한 백트레킹
            }
        }
    }
}
