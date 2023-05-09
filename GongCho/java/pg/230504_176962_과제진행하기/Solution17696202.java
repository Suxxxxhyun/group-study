package Programmers;

//7:50 ~ 8:20
import java.util.*;

class Solution17696202 {
  
  ArrayList<String> answer = new ArrayList<String>();
  PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>(){
     public int compare(Node n1, Node n2){
         return n1.start - n2.start;
     } 
  });
  class Node{
      String name;
      int start, playtime;
      
      public Node(String name, int start, int playtime){
          this.name = name;
          this.start = start;
          this.playtime = playtime;
      }
  }
  
  public ArrayList<String> solution(String[][] plans) {
      
      for(int i=0; i<plans.length; i++){
          String[] st = plans[i][1].split(":");
          int h = Integer.parseInt(st[0]);
          int m = Integer.parseInt(st[1]);
          int playtime = Integer.parseInt(plans[i][2]);
          pq.offer(new Node(plans[i][0], h * 60 + m, playtime));
      }
      
      Stack<Node> stopped = new Stack<Node>();
      
      while(!pq.isEmpty()){
          //music, computer, science
          Node currentLes = pq.poll();
          
          int end = currentLes.start + currentLes.playtime;
          
          if(!pq.isEmpty()){
              //computer, science, history
              Node nextLes = pq.peek();
              if(end > nextLes.start){
                  //현재시각
                  int ctime = currentLes.playtime - (nextLes.start - currentLes.start);
                  stopped.push(new Node(currentLes.name, currentLes.start, ctime));
                  //System.out.println(ctime);
              } else if(end == nextLes.start){
                  answer.add(currentLes.name);
              } else {
                  answer.add(currentLes.name);
                  int currentTime = currentLes.start + currentLes.playtime;
                  while(!stopped.isEmpty()){
                      Node n = stopped.pop();
                      //System.out.println(n.name + "," + n.start + "," + n.playtime);
                      //System.out.println(nextLes.name + "," + nextLes.start + "," + nextLes.playtime);
                      if(currentTime + n.playtime > nextLes.start){
                          int ing = n.playtime - (nextLes.start - currentTime);
                          stopped.push(new Node(n.name, n.start, ing));
                          break;
                      } else {
                          currentTime += n.playtime;
                          answer.add(n.name);
                      }
                  }
              }
          } else {
              answer.add(currentLes.name);
              if(stopped.isEmpty()){
                  break;
              } else {
                  while(!stopped.isEmpty()){
                      answer.add(stopped.pop().name);
                  }   
              }
          }
      }
      return answer;
  }
}
