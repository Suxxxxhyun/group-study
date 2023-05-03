package Level3;

import java.util.*;
//인접리스트를 무조건 만들어야하는 줄 알았는데, 정점이 인덱스가 아닌 문자열이 있는 정점이라,
//어떻게 표현하는것에서 막혔는데, 알고보니, 인접리스트를 만들기 어렵다면,
//단순히 완탐으로 해볼까? + String path = " " 를 생성하여, 여기에 방문한 곳부터 차례대로
//추가할 수는 없을까? 라는 접근을 얻음.
class Solution43164 {

    ArrayList<String> list = new ArrayList<String>();
    boolean[] visited;

    public String[] solution(String[][] tickets) {

        visited = new boolean[tickets.length];
        dfs(0, "ICN", "ICN", tickets);
        Collections.sort(list);
        return list.get(0).split(" ");
    }

    void dfs(int idx, String now, String path, String[][] tickets){
        if(idx == tickets.length){
            list.add(path);
            return;
        }

        for(int i=0; i<tickets.length; i++){
            if(!visited[i] && now.equals(tickets[i][0])){
                visited[i] = true;
                dfs(idx + 1, tickets[i][1], path + " " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }
}
