/** 2023.08.01 ( 09:25 ~ 09:45 )

 제한: 2초, 128mb
 입력:
  1. 가로 N, 세로 M (1 ~ 100)
  2. O(N^4)

 목표: W영역 구하기, B영역 구하기
 -> BFS, DFS

 설계:
 1. (i, j) DFS 방문시작 (방문체크, 해제는 X)
 2. 전역변수로 영역 수 count 관리

 */

import java.io.*;

public class Main {
    private static int R, C, areaElemCount, myPower, enemyPower;
    private static int[] dr = {1, -1, 0, 0};
    private static int[] dc = {0, 0, 1, -1};
    private static char[][] board;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sizeInfo = br.readLine().split(" ");
        C = Integer.parseInt(sizeInfo[0]);
        R = Integer.parseInt(sizeInfo[1]);
        board = new char[R][C];
        visited = new boolean[R][C];
        for(int row=0; row<R; row++) {
            board[row] = br.readLine().toCharArray();
        }
        pro();
        System.out.println(String.format("%d %d", myPower, enemyPower));
    }

    private static void pro() {
        for(int startRow=0; startRow<R; startRow++) {
            for(int startCol=0; startCol<C; startCol++) {
                //1. 영역 수 초기화
                areaElemCount = 0;
                char target = board[startRow][startCol];
                if(visited[startRow][startCol]) {
                    continue;
                }
                //2. (i,j) dfs 탐색 시작
                //3. 영역 수에 대한 위력 갱신
                visited[startRow][startCol] = true;
                areaElemCount ++;
                dfs(startRow, startCol, target);
                updatePower(target, areaElemCount);
            }
        }
    }

    private static void dfs(int row, int col, char target) {

        for(int d=0; d<4; d++) {
            int nr = row + dr[d];
            int nc = col + dc[d];
            if(isInRange(nr, nc) && !visited[nr][nc] && target == board[nr][nc]) {
                visited[nr][nc] = true;
                areaElemCount ++;
                dfs(nr, nc, target);
            }
        }
    }

    private static boolean isInRange(int row, int col) {
        return 0 <= row && row < R && 0 <= col && col < C;
    }

    private static void updatePower(char target, int areaElemCount) {
        if(target == 'W') {
            myPower += (int) Math.pow(areaElemCount, 2);
        } else {
            enemyPower += (int) Math.pow(areaElemCount, 2);
        }
    }
}
