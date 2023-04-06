package baekjun.src.baekjun.BFSDFS;

import java.io.*;
import java.util.*;
//위,아래,왼쪽,오른쪽,앞,뒤라고 하는데 앞,뒤..?
//최소일수라고 하니 bfs로 풀어야할것같음.
//와씨; 몇층? 층을 어떻게 그래프로 나타내지;; 층을 또 어떻게 전파한담;; 방문처리를 어떻게 한담;;
//설마설마설마.. 3차원배열을 이용해보자...... -> 할 수 있을듯!
//14라인처럼 이차원배열을 타입으로 하는 map을 생성해줄까?
//multisourceBFS네! 출발점을 여러군데로 해서 전파하는 연구소와 비슷함.
//연구소 같은 경우는, 출발점을 여러군데로 하는 것을 입력받는 곳에서 바로 큐에 넣어주지 않고,
//bfs메서드안의 시작부분에 바이러스가 있는 곳을 큐에 할당함.
//하지만 이 방법은, bfs메소드를 할때마다, 바이러스가있는 곳을 찾고 큐에 넣어주니,
//더 비효율적일듯! 입력받는 곳에 미리 큐에 넣어주는게 더 효율적일듯하다.
//그렇다면 익은 토마토의 좌표를 미리 큐에 넣어주자.
//~3:07까지 무조건 고민하기(답보기금지! -> 굿)

//연구소 이따가 multisourceBFS의 출발점을 큐에 넣어줬는지 리스트에 넣어주었는지 확인하기. -> 큐에 넣어줌.

//최소일수는 미로탐색문제처럼 실제 배열에 이전의 값을 더해주는 방식으로 진행하면, 최소일수를 구할 수 있다.
public class Main7569 {

    static StringTokenizer st;
    static int n,m,h;
    static int[][] dir = {{0,-1,0},{0,1,0},{0,0,-1},{0,0,1},{1,0,0},{-1,0,0}};
    static int[][][] map;
    //visited가 필요없는 이유는 익은 토마토를 기준으로 토마토를 익게 만들어줄것인데,
    //토마토가 익었음을 map에 1로 갱신시켜 표현한다.
    //static boolean[][][] visited;
    //q = 익은 토마토를 넣어주는 공간
    static Queue<Node> q = new LinkedList<Node>();
    static class Node{
        int h, x, y;

        public Node(int h, int x, int y){
            this.h = h;
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new int[h][n][m];
        boolean not_riped = false;
        for(int i=0; i<h; i++){
            for(int j=0; j<n; j++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int k=0; k<m; k++){
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if(map[i][j][k] == 0){
                        not_riped = true;
                    } else if(map[i][j][k] == 1){
                        q.offer(new Node(i,j,k));
                    }
                }
            }
        }

        //주어진 토마토가 모두 익은 상황이라면,
        if(!not_riped){
            System.out.println(0);
        } else {
            bfs();
            boolean not_every_riped = false;
            int result = Integer.MIN_VALUE;
            for(int i=0; i<h; i++){
                for(int j=0; j<n; j++){
                    for(int k=0; k<m; k++){
                        if(map[i][j][k] == 0){
                            not_every_riped = true;
                            break;
                        }
                        if(map[i][j][k] > result){
                            result = map[i][j][k];
                        }
                    }
                }
            }
            if(not_every_riped){
                System.out.println(-1);
            } else {
                System.out.println(result - 1);
            }
        }
    }

    static void bfs(){
        while(!q.isEmpty()){
            Node node = q.poll(); //(1,1,2)에 있는 익은 토마토가 꺼내질 것임.
            int nh = 0, nx = 0, ny = 0;

            for(int i=0; i<dir.length; i++){
                nh = node.h + dir[i][0];
                nx = node.x + dir[i][1];
                ny = node.y + dir[i][2];

                if(nh < 0 || nx < 0 || ny < 0 || nh >= h || nx >= n || ny >= m){
                    continue;
                }

                if(map[nh][nx][ny] != 0){
                    continue;
                }

                if(map[nh][nx][ny] == 0){
                    map[nh][nx][ny] = map[node.h][node.x][node.y] + 1;
                    q.offer(new Node(nh,nx,ny));
                }
            }

            /*System.out.println("전파하려는 토마토 : " + node.h + "," + node.x + "," + node.y);
            for(int i=0; i<h; i++){
                System.out.println(i + "면");
                for(int j=0; j<n; j++){
                    for(int k=0; k<m; k++){
                        System.out.print(map[i][j][k] + " ");
                    }
                    System.out.println();
                }
                System.out.println();
            }*/
        }
    }
}
