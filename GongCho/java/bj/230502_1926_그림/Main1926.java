package baekjun.src.baekjun.BFSDFS;

//2:44 ~ 3:15
import java.io.*;
import java.util.*;
public class Main1926 {

    static int n,m, cnt, count;
    static StringTokenizer st;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    static ArrayList<Integer> list = new ArrayList<Integer>();
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
        map = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    bfs(i,j);
                    cnt += 1;
                    list.add(count);
                    count = 0;
                }
            }
        }
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(cnt);
        if(!list.isEmpty()){
            System.out.println(list.get(0));
        } else {
            System.out.println(0);
        }


    }

    static void bfs(int x, int y){
        Queue<Node> q = new LinkedList<Node>();
        visited[x][y] = true;
        q.offer(new Node(x,y));
        while(!q.isEmpty()){
            Node node = q.poll();
            count += 1;

            for(int i=0; i<4; i++){
                int nx = node.x + dir[i][0];
                int ny = node.y + dir[i][1];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m){
                    continue;
                }

                if(!visited[nx][ny] && map[nx][ny] == 1){
                    q.offer(new Node(nx,ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
