package Level2;

import java.util.*;
//그래프문제라고 해서 무조건 그래프를 생성하려고 접근하지 말것!
//그래프를 생성하지 않고도 풀 수 있다!

public class Solution169199 {

    Node Robot = null, Goal = null;
    int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    boolean[][] visited;

    class Node{
        int x, y, depth;

        public Node(int x, int y, int depth){
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }

    public int solution(String[] board) {

        visited = new boolean[board.length][board[0].length()];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length(); j++){
                if(board[i].charAt(j) == 'R'){
                    Robot = new Node(i,j,0);
                } else if(board[i].charAt(j) == 'G'){
                    Goal = new Node(i,j,0);
                }
            }
        }

        return bfs(board);
    }

    int bfs(String[] board){
        Queue<Node> q = new LinkedList<Node>();
        q.offer(Robot);
        while(!q.isEmpty()){
            Node current = q.poll();

            if(current.x == Goal.x && current.y == Goal.y){
                return current.depth;
            }

            for(int i=0; i<4; i++){
                int nx = current.x + dir[i][0];
                int ny = current.y + dir[i][1];

                while(isRange(nx,ny,board) && board[nx].charAt(ny) != 'D'){
                    nx += dir[i][0];
                    ny += dir[i][1];
                }

                nx -= dir[i][0];
                ny -= dir[i][1];

                if(visited[nx][ny]){
                    continue;
                }

                q.offer(new Node(nx,ny,current.depth + 1));
                visited[nx][ny] = true;
            }
        }
        return -1;
    }

    boolean isRange(int x, int y, String[] board){
        return x >= 0 && y >= 0 && x < board.length && y < board[0].length();
    }
}