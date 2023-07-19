import java.io.*;
import java.util.*;

/** 2023.07.19 (09:37 ~

 제한: 2초, 512mb
 입력:
  1. 격자 board 가로, 세로 N: 2 ~ 20
  2. 가능 시간복잡도: O(N^6)

 목표: 격자가 주어졌을 때, 아기 상어가 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는 시간
 -> 시뮬레이션

 - 격자 한칸에는 물고기가 최대 1마리
 - 아기상어, 물고기는 모두 크기를 갖고 있다.
 
 아기상어
 - 처음 크기: 2
 - 1초에 상하좌우로 인접한 한 칸씩 이동
 - 자신보다 큰 물고기가 있는 칸은 지나갈 수 없다.
 - 자신보다 작은 물고기만 먹을 수 있다.
 - 자신의 크기와 같은 수의 물고기를 먹을 때 마다 크기가 1 증가한다.



 시뮬레이션 설계:
 [관리대상]
 1. 격자 board
 2. 아기상어(크기, 위치, 먹은 물고기 수)
 3. 물고기들(크기, 위치)


 1. 물고기가 존재하지 않으면 종료

 2. 물고기가 1마리면, 그 물고기를 먹으러 간다.
    물고기와 거리를 계산한다.
    해당 물고기를 제거한다.
    상어의 위치를 갱신한다.

 3. 물고기가 여러마리라면, 각 물고기와의 거리를 계산한다.
    거리계산: |row1 - row2| + |col - col2|
    res: List<distance, row, col>
    거리 오름차순 -> row 오름차순 -> col 오름차순으로 정렬한다.
    리스트의 0번째 물고기를 먹으러 간다.
    해당 물고기를 제거한다.
    상어의 위치를 갱신한다.


 4. 먹은 물고기 수를 갱신한다.
    크기 == 먹은 물고기 수 -> 크기 1 증가, 먹은 물고기 수 0 초기화
 5. 시간을 갱신한다.

 */
public class Main {
    private static int N;
    private static Shark shark;
    private static List<Fish> fishes;
    private static int[] dr = {0, 0, -1, 1};
    private static int[] dc = {1, -1, 0, 0};
    private static int[][] board;
    public static void main(String[] args) throws IOException {
        init();
        int totalTime = pro();
        System.out.println(totalTime);
    }

    private static int pro() {
        int time = 0;
        while(true) {
//            System.out.println(shark);
            // 1. 다음 먹을 물고기를 구한다.
            Fish fish = bfs();
//            System.out.println("먹을 물고기: " + fish);
            // 2. 먹을 수 있는 물고기가 없다면 종료한다.
            if(fish == null) { break; }
            // 3. 물고기를 먹는다.
            eatFish(fish);
            // 4. 상어 위치를 갱신한다.
            updateSharkPosition(fish);
            // 5. 시간을 갱신한다.
            time += fish.distanceFromShark;
//            System.out.println();
        }
//        System.out.println(time);
        return time;
    }

    private static void eatFish(Fish target) {
        // 1. 물고기 격자에서 제거
        board[target.row][target.col] = 0;
        // 2. 상어 물고기 먹은 개수 및 크기 갱신
        shark.updateSize();
    }

    // 상어 -> 모든 격자 최소거리 구하고
    // 먹을 수 있는 물고기들 List로 리턴
    private static Fish bfs() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        settingBfsStart(queue, visited);
        List<Fish> canEatFishes = new ArrayList<>();
        while(!queue.isEmpty()) {
            int[] curInfo = queue.poll();
            int row = curInfo[0], col = curInfo[1], cost = curInfo[2];

            // 목적지: X
            // 연결된곳: 인접 4방향
            for(int d=0; d<4; d++) {
                // 갈수있는곳: 방문X, 빈칸, 크기 이하인 물고기칸
                int nr = row + dr[d];
                int nc = col + dc[d];

                if(!isInRange(nr, nc)) {
                    continue;
                }
                if(visited[nr][nc]) {
                    continue;
                }
                if(board[nr][nc] != 0 && board[nr][nc] > shark.size) {
                    continue;
                }

                queue.add(new int[] {nr, nc, cost+1});
                visited[nr][nc] = true;

                if (board[nr][nc] != 0 && board[nr][nc] < shark.size) {
                    canEatFishes.add(new Fish(board[nr][nc], nr, nc, cost + 1));
                }
            }
        }
//        System.out.println(canEatFishes);
        if(canEatFishes.isEmpty()) {
            return null;
        }
        sort(canEatFishes);
        return canEatFishes.get(0);
    }

    private static boolean isInRange(int row, int col) {
        return 0<= row && row < N && 0 <= col && col < N;
    }

    private static void settingBfsStart(Queue<int[]> queue, boolean[][] visited) {
        queue.add(new int[] {shark.row, shark.col, 0});
        visited[shark.row][shark.col] = true;
    }

    private static void sort(List<Fish> fishes) {
        Collections.sort(fishes, new Comparator<Fish>() {
            @Override
            public int compare(Fish o1, Fish o2) {
                if(o1.distanceFromShark == o2.distanceFromShark) {
                    if(o1.row == o2.row) {
                        return o1.col - o2.col;
                    }
                    return o1.row - o2.row;
                }
                return o1.distanceFromShark - o2.distanceFromShark;
            }
        });
    }

    private static void updateSharkPosition(Fish eatFish) {
        shark.row = eatFish.row;
        shark.col = eatFish.col;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for(int row=0; row<N; row++) {
            String[] info = br.readLine().split(" ");
            for(int col=0; col<N; col++) {
                int boardState = Integer.parseInt(info[col]);
                board[row][col] = boardState;
                if(boardState == 9) {
                    shark = new Shark(2, row, col, 0);
                    board[row][col] = 0;
                }
            }
        }
    }
}

class Fish {
    int size;
    int row;
    int col;
    int distanceFromShark;

    public Fish(int size, int row, int col, int distanceFromShark) {
        this.size = size;
        this.row = row;
        this.col = col;
        this.distanceFromShark = distanceFromShark;
    }

    @Override
    public String toString() {
        return "Fish{" +
                "size=" + size +
                ", row=" + row +
                ", col=" + col +
                ", distanceFromShark=" + distanceFromShark +
                '}';
    }
}

class Shark {
    int size;
    int row;
    int col;
    int eatCount;

    public Shark(int size, int row, int col, int eatCount) {
        this.size = size;
        this.row = row;
        this.col = col;
        this.eatCount = eatCount;
    }

    public void updateSize() {
        eatCount ++;
        if(size == eatCount) {
            size ++;
            eatCount = 0;
        }
    }

    @Override
    public String toString() {
        return "Shark{" +
                "size=" + size +
                ", row=" + row +
                ", col=" + col +
                ", eatCount=" + eatCount +
                '}';
    }
}
