package Programmers;

//12:53 ~ 1:20
import java.util.*;

class Solution178871 {
  
  String[] answer;
  Map<String, Integer> NameByKey = new HashMap<String, Integer>();
  Map<Integer, String> RankByKey = new HashMap<Integer, String>();
  
  public String[] solution(String[] players, String[] callings) {
      
      answer = new String[players.length];
      
      //5¸¸
      for(int i=0; i<players.length; i++){
          NameByKey.put(players[i], i);
          RankByKey.put(i,players[i]);
      }
      
      //10¸¸
      for(int i=0; i<callings.length; i++){
          String currentName = callings[i];
          int currentRank = NameByKey.get(currentName);
          
          String front_name = RankByKey.get(currentRank - 1);
          
          NameByKey.put(currentName, currentRank - 1);
          RankByKey.put(currentRank - 1 ,currentName);
          
          NameByKey.put(front_name, currentRank);
          RankByKey.put(currentRank, front_name);
      }
      
      for(int i=0; i<answer.length; i++){
          answer[i] = RankByKey.get(i);
      }
      
      return answer;
  }
}
