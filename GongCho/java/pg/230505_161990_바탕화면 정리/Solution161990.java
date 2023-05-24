package Programmers;

//7:30 ~ 8:00
class Solution161990 {
  
  int lux = 51, luy = 51, rdx = 0, rdy = 0;
  
  public int[] solution(String[] wallpaper) {
  
      
      for(int i=0; i<wallpaper.length; i++){
          for(int j=0; j<wallpaper[i].length(); j++){
              if(wallpaper[i].charAt(j) == '#'){
                  lux = Math.min(lux, i);
                  luy = Math.min(luy, j);
                  rdx = Math.max(rdx, i);
                  rdy = Math.max(rdy, j);
              }
          }
      }
      
      int [] answer = {lux, luy, rdx + 1, rdy + 1};
      
      return answer;
  }
}
