package Level1;

//7:16 ~ 7:46

import java.util.*;

class Solution176963 {

    int[] answer;

    public int[] solution(String[] name, int[] yearning, String[][] photo) {

        answer = new int[photo.length];

        Map<String,Integer> score = new HashMap<String,Integer>();

        for(int i=0; i<name.length; i++){
            score.put(name[i], yearning[i]);
        }

        System.out.println(score);


        for(int i=0; i<photo.length; i++){
            for(int j=0; j<photo[i].length; j++){
                if(score.get(photo[i][j]) == null){
                    continue;
                }
                answer[i] += score.get(photo[i][j]);
            }
        }
        return answer;
    }
}
