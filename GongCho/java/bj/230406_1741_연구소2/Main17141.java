package baekjun.src.baekjun.BFSDFS;

//~6:00까지 해보자!
//벽을 -1로 바꿔서 문제를 풀것이며, 바이러스를 놓을 수 있는 '2'라는 부분은 birus배열에 담아준다.
//map에는 바이러스를 놓을 수 있는 부분을 그냥 '0'으로 바꿔서 풀것임.
//왜냐? 미로탐색문제처럼 bfs로 시간을 재야하기때문.
import java.io.*;
import java.util.*;
public class Main17141 {

    static int n,m,bcnt, ans = Integer.MAX_VALUE;
    static StringTokenizer st;
    static int[][] map, birus;
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
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        birus = new int[10][2];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<n; j++){
                int a = Integer.parseInt(st.nextToken());
                if(a == 2) {
                    birus[bcnt][0] = i;
                    birus[bcnt][1] = j;
                    bcnt++;
                    a = 0;
                } else if(a == 1){
                    a = -1;
                }
                map[i][j] = a;
            }
        }
        pro(0,0);
        System.out.println((ans == Integer.MAX_VALUE) ? -1 : ans);
    }

    static void pro(int idx, int cnt){
        if(cnt == m){
            ans = Math.min(extend_bfs(), ans);
            return;
        }

        if(idx >= bcnt){
            return;
        }

        map[birus[idx][0]][birus[idx][1]] = 1;
        pro(idx + 1, cnt + 1);
        map[birus[idx][0]][birus[idx][1]] = 0;
        pro(idx + 1, cnt);
    }

    static int extend_bfs(){
        int res = 0;
        Queue<Node> q = new LinkedList<Node>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 1){
                    q.offer(new Node(i,j));
                }
            }
        }

        int[][] newMap = new int[n][n];
        copy(newMap, map);

        while(!q.isEmpty()){
            Node node = q.poll();

            for(int i=0; i<4; i++){
                int nx = node.x + dir[i][0];
                int ny = node.y + dir[i][1];

                if(nx < 0 || ny < 0 || nx >= n || ny >= n || newMap[nx][ny] == -1){
                    continue;
                }

                if(newMap[nx][ny] == 0){
                    q.offer(new Node(nx,ny));
                    newMap[nx][ny] = newMap[node.x][node.y] + 1;
                }

            }
        }

        boolean cannot = false;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                //System.out.print(newMap[i][j] + " ");
                if(newMap[i][j] == 0){
                    cannot = true;
                }
                if(res < newMap[i][j]){
                    res = newMap[i][j];
                }
            }
            //System.out.println();
        }
        //System.out.println("==================");
        //System.out.println("바이러스를 확산시킨 시간 = " + res);
        if(cannot){
            return Integer.MAX_VALUE;
        } else {
            return res - 1;
        }
    }

    static void copy(int[][] newMap, int[][] map){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                newMap[i][j] = map[i][j];
            }
        }
    }
}
