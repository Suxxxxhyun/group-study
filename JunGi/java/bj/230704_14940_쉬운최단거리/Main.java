import java.io.*;
import java.util.*;

/** 2023.07.04 (13:45 ~
 * 제한: 1초, 128mb
 * 입력:
 *  - 지도 세로/가로 크기 n,m : 2 ~ 1,000 -> O(N^2)
 *  - board[i][j] = 0 <- 갈수없는 땅, 1 <- 갈수있는 땅, 2 <- 목표지점(한개만 주어짐)
 *
 * goal: 모든 지점 -> 목표지점 최단거리 구하기
 *   -> * 바꿔말하면, 목표지점 -> 모든 지점 최단거리 구하면 한번에 끝남 *
 * * 원래 갈 수 있는 땅 중에서 갈 수 없는 곳은 -1 출력 *
 *
 * type:
 *   1) 01bfs -> O(N^2) -> O (구현 쉬움)
 *   2) dijkstra -> O(N logE)
 *   3) floyd -> O(N^3) -> X
 *
 *
 *
 * [01bfs 설계]
 * 1. 연결된곳: 4방향
 * 2. 갈수있는곳: 배열 안, 0이 아닌 곳
 * 3. 목적지: 2인 곳
 *
 */
public class Main {
    private static int R, C, startRow, startCol;
    private static int[] dr = {1, -1, 0, 0};
    private static int[] dc = {0, 0, 1, -1};
    private static int[][] board, distance;
    public static void main(String[] args) throws IOException {
        initialBoard();
        bfs();
        printResult();
    }

    private static void printResult() {
        StringBuilder sb = new StringBuilder();
        for(int row=0; row<R; row++) {
            for(int col=0; col<C; col++) {
                if(board[row][col] == 0) {
                    sb.append("0").append(" ");
                } else if (distance[row][col] == -1) {
                    sb.append("-1").append(" ");
                } else {
                    sb.append(distance[row][col]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        distance = new int[R][C];
        startSetting(queue, distance);

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int row = cur[0], col = cur[1];
            for(int d=0; d<4; d++) {
                int nr = row + dr[d];
                int nc = col + dc[d];

                if(!isInRange(nr, nc)) {
                    continue;
                }
                if(distance[nr][nc] != -1) {
                    continue;
                }
                if(board[nr][nc] == 0) {
                    continue;
                }
                distance[nr][nc] = distance[row][col] + 1;
                queue.add(new int[] {nr, nc});
            }
        }
    }

    private static boolean isInRange(int row, int col) {
        return 0 <= row && row < R && 0 <= col && col < C;
    }

    private static void startSetting(Queue<int[]> queue, int[][] distance) {
        queue.add(new int[] {startRow, startCol});
        for(int row = 0; row< R; row++) {
            Arrays.fill(distance[row], -1);
        }
        distance[startRow][startCol] = 0;
    }

    private static void initialBoard() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new int[R][C];
        for(int row=0; row<R; row++) {
            st = new StringTokenizer(br.readLine());
            for(int col=0; col<C; col++) {
                board[row][col] = Integer.parseInt(st.nextToken());
                if(board[row][col] == 2) {
                    startRow = row;
                    startCol = col;
                }
            }
        }
    }
}
