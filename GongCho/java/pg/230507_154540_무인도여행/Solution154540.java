package Level2;

//10:12 ~ 10:42
//x가 바다, 숫자는 무인도
//칸에 적힌 숫자를 모두 합한 값은 해당 무인도에서 최대 며칠동안 머물 수 있는지를 나타냄
//전형적인 dfs문제
import java.util.*;
public class Solution154540 {

    int[][] map;
    boolean[][] visited;
    int cnt = 0, sum = 0;
    int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

    public List<Integer> solution(String[] maps) {

        List<Integer> answer = new ArrayList<Integer>();

        map = new int[maps.length][maps[0].length()];
        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[i].length(); j++){
                char c = maps[i].charAt(j);
                if(c == 'X'){
                    map[i][j] = -1;
                } else if(c >= '1' && c <= '9'){
                    map[i][j] = c - '0';
                    cnt++;
                }
            }
        }

        if(cnt == 0){
            answer.add(-1);
        } else {
            visited = new boolean[map.length][map[0].length];
            for(int i=0; i<map.length; i++){
                for(int j=0; j<map[i].length; j++){
                    if(!visited[i][j] && map[i][j] != -1){
                        dfs(i,j, map);
                        answer.add(sum);
                        sum = 0;
                    }
                }
            }
            Collections.sort(answer);
        }

        return answer;
    }

    void dfs(int x, int y, int[][] map){
        visited[x][y] = true;
        sum += map[x][y];

        for(int i=0; i<4; i++){
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if(nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length){
                continue;
            }

            if(map[nx][ny] == -1){
                continue;
            }

            if(!visited[nx][ny]){
                dfs(nx, ny, map);
            }
        }

    }
}
