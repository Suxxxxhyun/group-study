package baekjun.src.baekjun.BFSDFS;

//7:14 ~ 7:44
//visited배열을 따로 만들지 않고 map배열에 최소일수를 누적한다.
//bfs로 익은 토마토들의 근처를 확인한다.
import java.io.*;
import java.util.*;
public class Main7576 {

    static StringTokenizer st;
    static int m,n,min_day = 0;
    static int[][] map;
    static boolean process = false;
    static Queue<Node> ripedQ = new LinkedList<Node>();
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

    static class Node{
        int x, y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0){
                    process = true;
                } else if(map[i][j] == 1){
                    ripedQ.offer(new Node(i,j));
                }
            }
        }
        if(process){
            //토마토가 익을 수 있다면, 그때의 최소일수
            if(pro()){
                System.out.println(min_day - 1);
            }
            //토마토가 익지 못하는 상황
            else {
                System.out.println(-1);
            }

        } else {
            System.out.println(0);
        }
    }

    static boolean pro(){
        while(!ripedQ.isEmpty()){
            Node q = ripedQ.poll();

            for(int i=0; i<4; i++){
                int nx = q.x + dir[i][0];
                int ny = q.y + dir[i][1];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m){
                    continue;
                }

                //토마토가 들어있지 않다면 넘어감.
                if(map[nx][ny] == -1){
                    continue;
                }

                if(map[nx][ny] == 0){
                    map[nx][ny] = map[q.x][q.y] + 1;
                    ripedQ.offer(new Node(nx, ny));
                }
            }
        }

        boolean isNotCan = true;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == 0){
                    isNotCan = false;
                    break;
                }
                min_day = Math.max(map[i][j], min_day);
                //System.out.print(map[i][j] + " ");
            }
            //System.out.println();
        }
        return isNotCan;
    }
}
