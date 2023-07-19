package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    09:05~11:00

    가장 가까운 물고기
    가장 위에 있는 물고기
    가장 왼쪽에 있는 물고기

    자신보다 작은 물고기만 먹기 가능
    *같은 크기는 먹기 불가능
    *자신의 크기와 같은 수의 물고기 먹으면 크기 1증가

    최단시간?
    BFS? // 상하좌우 한칸씩 이동
    아기상어 크기 = 2
    아기상어 위치 = 9

 */

class Node {
    int x;
    int y;
    int dis;

    Node (int x, int y, int dis) {
        this.x = x;
        this.y = y;
        this.dis = dis;
    }
}
public class BOJ_16236_230719 {

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    // 큐에 아기상어 위치 담기
    static Queue<Node> q = new LinkedList<>();
    static int[][] graph;
    static int N;
    static int size = 2, eatCnt = 0, moveCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 9) {
                    q.offer(new Node(i,j,0));
                    // 큐에 담고 위치 표시용 9 제거
                    graph[i][j] = 0;
                }
            }
        }

        // size = 아기상어 크기
        // eatCnt = 먹은 물고기 수
        // moveCnt = 움직인 총 거리
        System.out.println(bfs());
    }


    // BFS
    static int bfs() {

        while (true) {
            ArrayList<Node> list = new ArrayList<>();
            int[][] distance = new int[N][N];

            while(!q.isEmpty()) {
                //아기상어 위치 반환
                Node node = q.poll();
                int x = node.x;
                int y = node.y;

                for (int idx = 0; idx < 4; idx++) {
                    int nx = x + dx[idx];
                    int ny = y + dy[idx];

                    // 범위 벗어나지 않는다면
                    if (isRange(nx,ny) && distance[nx][ny] == 0 && graph[nx][ny] <= size) {
                        distance[nx][ny] = distance[x][y] + 1;
                        q.offer(new Node(nx, ny, distance[nx][ny]));

                        // 먹을 수 있는 친구들
                        if (1 <= graph[nx][ny] && graph[nx][ny] <= 6 && graph[nx][ny] < size) {
                            list.add(new Node(nx, ny, distance[nx][ny]));
                        }
                    }
                }
            }

            // 먹을 수 있는 물고기가 없음
            if (list.size() == 0) {
                return moveCnt;
            }

            Node now = list.get(0);

            for (int i = 1; i < list.size(); i++) {

                // 거리가 가장 가까운 물고기
                if (now.dis > list.get(i).dis) now = list.get(i);
                    // 거리가 가까운 물고기가 많다면
                else if (now.dis == list.get(i).dis) {
                    // 위에 있는 물고기 갱신
                    if (now.x > list.get(i).x) now = list.get(i);
                        // 가장 위의 물고기 여러마리라면 (같은 x좌표)
                    else if (now.x == list.get(i).x) {
                        // 왼쪽에 있는 물고기로 갱신
                        if (now.y > list.get(i).y) now = list.get(i);
                    }
                }
            }

            graph[now.x][now.y] = 0; // 조건 만족하는 물고기 잡아먹음
            moveCnt += now.dis; // 이동거리 갱신
            eatCnt++; // 먹은 물고기 갱신

            if (size == eatCnt) {
                size++;
                eatCnt = 0;
            }

            q.offer(now);
        }
    }

    static boolean isRange(int nx, int ny) {
        return (nx >= 0 && ny >= 0 && nx < N && ny < N);
    }
}
