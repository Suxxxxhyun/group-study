package baekjun.src.baekjun.BFSDFS;

import java.io.*;
import java.util.*;
public class Main3055 {

    static int r,c,result = Integer.MIN_VALUE;
    static StringTokenizer st;
    static char[][] graph;
    static Queue<Node> water = new LinkedList<Node>();
    static Queue<Node> Sq = new LinkedList<Node>(); //고슴도치의 좌표를 담는 공간
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    static class Node{
        int x, y, move_count; //이동횟수

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }

        public Node(int x, int y, int move_count){
            this.x = x;
            this.y = y;
            this.move_count = move_count;
        }

        public String toString(){
            return "x : " + x + ", y : " + y + ", move_count : " + move_count;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        graph = new char[r][c];
        for(int i=0; i<r; i++){
            String str = br.readLine();
            for(int j=0; j<c; j++){
                if(str.charAt(j) == '*'){
                    water.offer(new Node(i,j));
                } else if(str.charAt(j) == 'S'){
                    Sq.offer(new Node(i,j,0));
                }
                graph[i][j] = str.charAt(j);
            }
        }

        bfs();
        /*for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }*/
        if(result == Integer.MIN_VALUE){
            System.out.println("KAKTUS");
        } else {
            System.out.println(result);
        }
    }

    static void bfs(){
        while(!Sq.isEmpty()){

            int water_size = water.size();
            for(int j=0; j<water_size; j++){
                Node node = water.poll();
                //System.out.println(node);

                for(int i=0; i<4; i++){
                    int nx = node.x + dir[i][0];
                    int ny = node.y + dir[i][1];

                    if(nx < 0 || ny < 0 || nx >= r || ny >= c){
                        continue;
                    }

                    if(graph[nx][ny] == '.'){
                        graph[nx][ny] = '*';
                        water.offer(new Node(nx,ny));
                    }
                }
            }

            int Sq_size = Sq.size();
            for(int k=0; k<Sq_size; k++){
                Node sgosm = Sq.poll();
                //System.out.println(sgosm);

                for(int i=0; i<4; i++){
                    int nx = sgosm.x + dir[i][0];
                    int ny = sgosm.y + dir[i][1];

                    if(nx < 0 || ny < 0 || nx >= r || ny >= c){
                        continue;
                    }

                    if(graph[nx][ny] == 'D'){
                        result = Math.max(sgosm.move_count + 1, result);
                        return;
                    }

                    if(graph[nx][ny] == '.'){
                        graph[nx][ny] = 'S';
                        Sq.offer(new Node(nx,ny,sgosm.move_count + 1));
                    }
                }
            }
        }
    }
}
