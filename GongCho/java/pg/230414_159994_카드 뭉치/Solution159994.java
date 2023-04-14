package Level1;

//3:51 ~ 4:20
//ArrayList에 contains가 있다.
import java.util.*;
class Solution159994 {

    String answer = "Yes";
    ArrayList<String> C1 = new ArrayList<String>();
    ArrayList<String> C2 = new ArrayList<String>();
    ArrayList<String> G = new ArrayList<String>();

    public String solution(String[] cards1, String[] cards2, String[] goal) {

        for(int i=0; i<cards1.length; i++){
            C1.add(cards1[i]);
        }

        for(int i=0; i<cards2.length; i++){
            C2.add(cards2[i]);
        }

        for(int i=0; i<goal.length; i++){
            G.add(goal[i]);
        }

        int C1_idx = 0, C2_idx = 0;

        for(int i=0; i<goal.length; i++){
            if(C1.contains(goal[i])){
                if(C1_idx != C1.indexOf(goal[i])){
                    answer = "No";
                    break;
                }
                C1_idx++;
            } else if(C2.contains(goal[i])){
                if(C2_idx != C2.indexOf(goal[i])){
                    answer = "No";
                    break;
                }
                C2_idx++;
            } else {
                answer = "No";
                break;
            }
        }
        return answer;
    }
}
