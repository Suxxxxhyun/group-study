package baekjun.src.baekjun.BFSDFS;

import java.io.*;
public class Main10026 {

    static int n, notsak, sak;
    static char[][] graph;
    static boolean[][] visited;
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new char[n][n];
        visited = new boolean[n][n];
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<n; j++){
                graph[i][j] = str.charAt(j);
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]){
                    ndfs(i,j);
                    notsak += 1;
                }
            }
        }

        visited = new boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]){
                    dfs(i,j);
                    sak += 1;
                }
            }
        }

        System.out.println(notsak + " " + sak);
    }

    static void ndfs(int x, int y){
        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if(nx < 0 || ny < 0 || nx >= n || ny >= n){
                continue;
            }

            if(!visited[nx][ny] && graph[x][y] == graph[nx][ny]){
                ndfs(nx,ny);
            }


        }
    }

    static void dfs(int x, int y){
        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if(nx < 0 || ny < 0 || nx >= n || ny >= n){
                continue;
            }

            if(!visited[nx][ny] && (graph[x][y] == 'R' || graph[x][y] == 'G') && (graph[nx][ny] == 'R' || graph[nx][ny] == 'G')){
                dfs(nx,ny);
            } else if(!visited[nx][ny] && (graph[x][y] == 'B') && (graph[nx][ny] == 'B')){
                dfs(nx,ny);
            }
        }
    }
}
