package Level1;

import java.util.*;
public class Solution17887102 {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        HashMap<String, Integer> player = new HashMap<>(); //[이름,랭크]
        HashMap<Integer, String> playerRank = new HashMap<>(); //[랭크,이름]

        for(int i=0; i<players.length; i++){
            player.put(players[i],i);
            playerRank.put(i,players[i]);
        }

        for(int i=0; i<callings.length; i++){
            int currentRank = player.get(callings[i]);
            String play = playerRank.get(currentRank);

            String frontplayer = playerRank.get(currentRank - 1);

            player.put(play, currentRank - 1);
            player.put(frontplayer, currentRank);

            playerRank.put(currentRank - 1, play);
            playerRank.put(currentRank, frontplayer);
        }

        for(int i=0; i<players.length; i++){
            answer[i] = playerRank.get(i);
        }

        return answer;
    }
}
