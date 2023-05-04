package Level1;

//10:36 ~ 11:10
//나도 map을 따로 만들지 않고 접근해보자.
import java.util.*;

public class Solution172928 {

    int[] answer;
    int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    Node Robot = null;

    class Node{
        int x, y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public int[] solution(String[] park, String[] routes) {

        for(int i=0; i<park.length; i++){
            for(int j=0; j<park[i].length(); j++){
                if(park[i].charAt(j) == 'S'){
                    Robot = new Node(i,j);
                    break;
                }
            }
        }

        move(park, routes);
        answer = new int[2];
        answer[0] = Robot.x;
        answer[1] = Robot.y;
        return answer;
    }

    void move(String[] park, String[] routes){
        for(int i=0; i<routes.length; i++){
            int x = Robot.x, y = Robot.y;
            int nx = x, ny = y;
            if(routes[i].charAt(0) == 'E'){
                int cnt = routes[i].charAt(2) - '0';
                for(int j=0; j<cnt; j++){
                    nx += dir[3][0];
                    ny += dir[3][1];

                    if(!isCan(nx, ny, park)){
                        nx = x;
                        ny = y;
                        break;
                    }
                }
            } else if(routes[i].charAt(0) == 'S'){
                int cnt = routes[i].charAt(2) - '0';
                for(int j=0; j<cnt; j++){
                    nx += dir[1][0];
                    ny += dir[1][1];
                    if(!isCan(nx, ny, park)){
                        nx = x;
                        ny = y;
                        break;
                    }
                }
            } else if(routes[i].charAt(0) == 'W'){
                int cnt = routes[i].charAt(2) - '0';
                for(int j=0; j<cnt; j++){
                    nx += dir[2][0];
                    ny += dir[2][1];
                    if(!isCan(nx, ny, park)){
                        nx = x;
                        ny = y;
                        break;
                    }
                }
            } else {
                int cnt = routes[i].charAt(2) - '0';
                for(int j=0; j<cnt; j++){
                    nx += dir[0][0];
                    ny += dir[0][1];
                    if(!isCan(nx, ny, park)){
                        nx = x;
                        ny = y;
                        break;
                    }
                }
            }

            Robot.x = nx;
            Robot.y = ny;
        }
    }

    boolean isCan(int x, int y, String[] park){
        if(x < 0 || y < 0 || x >= park.length || y >= park[0].length()){
            return false;
        } else if(park[x].charAt(y) == 'X'){
            return false;
        } else {
            return true;
        }
    }
}