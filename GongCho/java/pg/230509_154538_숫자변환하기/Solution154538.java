package Level2;

import java.util.*;
//최소변환횟수 = 최단거리 = bfs
//백준 숨바꼭질 문제와 같은 문제임.
public class Solution154538 {

    int answer = 0;
    int[] visited;

    public int solution(int x, int y, int n) {

        if(x == y){
            return answer;
        } else {
            visited = new int[1000001];
            answer = bfs(x,y,n);
            if(answer == -1){
                return answer;
            } else {
                return answer - 1;
            }
        }
    }

    int bfs(int x, int y, int n){
        Queue<Integer> q = new LinkedList<Integer>();
        visited[x] = 1;
        q.offer(x);

        while(!q.isEmpty()){
            int xx = q.poll();
            int nx;

            for(int i=0; i<3; i++){
                if(i == 0){
                    nx = xx + n;
                } else if(i == 1){
                    nx = xx * 2;
                } else {
                    nx = xx * 3;
                }

                if(nx == y){
                    return visited[xx] + 1;
                }

                if(nx <= 0 || nx > 1000000 || visited[nx] != 0){
                    continue;
                }

                if(visited[nx] == 0){
                    visited[nx] = visited[xx] + 1;
                    q.offer(nx);
                }
            }
        }

        return -1;
    }
}
