package Level2;

//11:47 ~ 12:10
//12:47 ~ 1:10
//내가 시도한 실패풀이

//graph는 -1이 있는 곳은 탈출구, -2가 있는 곳은 레버라고 하여 문제를 바꿔서 푼다.
//벽은 -3으로 바꿔서 문제를 푼다.
/*
아래 코드가 실패할 수 밖에 없는 이유는,
1)레버를 찾으러 가는 길에 O만 있는게 아니라 E가 있을 수도 있다.
2)출구를 찾으러 가는 길에 S가 있을 수 도 있다.

-> 1번의 경우로 포함해서 생각하면, 즉 예제가 ["SOEOL"]라고 주어질때,
내가 짠 Graph는 [00-10-2]로 바꿔서 풀게 될텐데,
레버가 있는 곳까지 그래프를 갱신하여(시간을 계산하면서) 이동하게 되는데,
중간에 출구를 만나버리는 순간, 시간이 더해지는게 아니라 음수로 인해서, 값이 빼지게 되므로,
논리가 어긋나게 된다.
 */

import java.util.*;

class Solution15999302 {

    int answer = 0, startX = 0, startY = 0, exitX = 0, exitY = 0, Rx = 0, Ry = 0;
    int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    int[][] graph;

    static class Node{
        int x, y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public int solution(String[] maps) {

        graph = new int[maps.length][maps[0].length()];
        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[i].length(); j++){
                if(maps[i].charAt(j) == 'S'){
                    startX = i;
                    startY = j;
                    graph[i][j] = 0;
                } else if(maps[i].charAt(j) == 'O'){
                    graph[i][j] = 0;
                } else if(maps[i].charAt(j) == 'X'){
                    graph[i][j] = -3;
                } else if(maps[i].charAt(j) == 'E'){
                    exitX = i;
                    exitY = j;
                    graph[i][j] = -1;
                } else {
                    Rx = i;
                    Ry = j;
                    graph[i][j] = -2;
                }
            }
        }

        int answer = bfs(startX, startY, Rx, Ry);
        System.out.println(answer);
        for(int i=0; i<graph.length; i++) {
            for(int j=0; j<graph[i].length; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
        if(answer > -1) {
            int next = bfs(Rx, Ry, exitX, exitY);
            System.out.println(next);
            if(next == -1) {
                answer = -1;
            } else {
                return next;
            }
        }

        return answer;
    }

    int bfs(int x, int y, int endX, int endY){
        Queue<Node> q = new LinkedList<Node>();
        q.offer(new Node(x,y));

        while(!q.isEmpty()){
            Node n = q.poll();

            for(int i=0; i<4; i++){
                int nx = n.x + dir[i][0];
                int ny = n.y + dir[i][1];

                if(nx < 0 || ny < 0 || nx >= graph.length || ny >= graph.length) {
                    continue;
                }

                if(nx == endX && ny == endY) {
                    graph[nx][ny] = graph[n.x][n.y] + 1;
                    return graph[nx][ny];
                }

                //벽인경우
                if(graph[nx][ny] == -3) {
                    continue;
                }

                if(graph[nx][ny] > 0) {
                    continue;
                }

                if(graph[nx][ny] == 0) {
                    graph[nx][ny] = graph[n.x][n.y] + 1;
                    q.offer(new Node(nx, ny));
                }

            }
        }
        return -1;
    }
}
