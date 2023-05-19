package Programmers;

//1:40 ~ 2:10
//bfs방식으로 해볼까?
import java.util.*;

class Solution172928 {
  
  int startX = 0, startY = 0;
  //북, 남, 서, 동
  int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
  char[][] map;
  class Node{
      int x, y;
      
      public Node(int x, int y){
          this.x = x;
          this.y = y;
      }
  }
  
  public int[] solution(String[] park, String[] routes) {
      
      int[] answer = new int[2];
      map = new char[park.length][park[0].length()];
      
      //입력받기
      input(park);
      
      int xx = startX;
      int yy = startY;
      int nx = xx;
      int ny = yy;
      
      for(int i=0; i<routes.length; i++){
          String[] st = routes[i].split(" ");
          int count = Integer.parseInt(st[1]);
          boolean isCan = true;
          if(st[0].equals("E")){
              for(int j=0; j<count; j++){
                  xx += dir[3][0];
                  yy += dir[3][1];
                  if(!confirm(xx, yy, park)){
                      isCan = false;
                      break;
                  };
              }
          } else if(st[0].equals("S")){
              for(int j=0; j<count; j++){
                  xx += dir[1][0];
                  yy += dir[1][1];
                  if(!confirm(xx, yy, park)){
                      isCan = false;
                      break;
                  };
              }
          } else if(st[0].equals("W")){
              for(int j=0; j<count; j++){
                  xx += dir[2][0];
                  yy += dir[2][1];
                  if(!confirm(xx, yy, park)){
                      isCan = false; 
                      break;
                  };
              }
          } else {
              for(int j=0; j<count; j++){
                  xx += dir[0][0];
                  yy += dir[0][1];
                  if(!confirm(xx, yy, park)){
                      isCan = false;
                      break;
                  };
              }
          }
         //System.out.println(isCan);
          if(confirm(xx,yy,park) || isCan){
              nx = xx;
              ny = yy;
              //System.out.println("xx = " + xx + ", yy = " + yy);
          } else {
              xx = nx;
              yy = ny;
          }
      }
      
      answer[0] = xx;
      answer[1] = yy;
      return answer;
  }
  
  //범위확인 + 장애물확인
  boolean confirm(int x, int y, String[] park){
      if(x < 0 || y < 0 || x >= park.length || y >= park[0].length()){
          return false;
      } if(map[x][y] == 'X'){
          return false;
      } else {
          return true;   
      }
  }
  
  void input(String[] park){
      for(int i=0; i<park.length; i++){
          for(int j=0; j<park[i].length(); j++){
              map[i][j] = park[i].charAt(j);
              if(map[i][j] == 'S'){
                  startX = i;
                  startY = j;
              }
          }
      }
  }
}
