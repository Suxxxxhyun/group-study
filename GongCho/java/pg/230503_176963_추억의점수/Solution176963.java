package Programmers;

//1:22 ~ 1:50
import java.util.*;

class Solution176963 {
  
  public int[] solution(String[] name, int[] yearning, String[][] photo) {
      
      int[] answer = new int[photo.length];
      Map<String, Integer> missing = new HashMap<String, Integer>();
      for(int i=0; i<name.length; i++){
          missing.put(name[i], yearning[i]);
      }
      
      for(int i=0; i<photo.length; i++){
          int sum = 0;
          for(int j=0; j<photo[i].length; j++){
              sum += missing.getOrDefault(photo[i][j], 0);
          }
          answer[i] = sum;
      }
      
      return answer;
  }
}
